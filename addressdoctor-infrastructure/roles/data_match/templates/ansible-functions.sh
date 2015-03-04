#!/bin/bash

HOME="/opt/casfw"
userinput="$1"

function error {
    local message=$1
    echo $1 >&2
    exit -1
}

function cleanupInstance {
      rm -rf {{ casfw_home }}/{{ data_match_instance }}
}

function stopTomcatPS {
     bash {{ casfw_home }}/current/{{ data_match_instance }}/bin/tomcat-ad.sh stop -force
}
 
function cleanupCurrent {
      rm -rf {{ casfw_home }}/current/{{ data_match_instance }}
}

function installcdi {
      cd {{ casfw_home }}
      xargs -a {{ release_environment }}-data-match-cdi-args.txt sh data-match-installer-{{ data_match_release_version }}.cdi      
}

function checkInstance {
       ps -ef | grep {{ data_match_instance }}
}

function finalCleanup {
    cd {{ casfw_home }}
    rm -f ansible-functions.sh
    rm -f itg-data-match-cdi-args.txt
    rm -f soap_envelope.xml
}

function checkDatabasesLoaded1 { 
  cd {{ casfw_home }}/address-doctor/databases/all
  databases=($(ls .))
  cd {{ casfw_home }}/{{ data_match_instance }}/data-match-{{ data_match_release_version }}/var/log/data-match-web
  result=1
  for filename in ${databases[*]}
  do
    extension="${filename##*.}"
    if [ ${extension} != "MD" ]
    then continue
    fi
    if ! grep -q ${filename} ad-engine.log
    then
      if [ $result -eq 1 ]
      then
      echo "NOT All Databases Loaded:"
      fi
      echo ${filename}
      result=0
    fi
  done
  if [ $result -eq 1 ]
  then
    echo "All Databases Loaded"
  fi  
}

function checkDatabasesLoaded {
    cd {{ casfw_home }}/{{ data_match_instance }}/data-match-{{ data_match_release_version }}/var/log/data-match-web

    unlockcodes=($(awk '/^</{if (n++) print ""}{printf $0}' ad-engine.log | grep -P "UnlockCode"))

    validateresult=0
    supplementaryresult=0
    geocodingresult=0
    for (( i=0 ; i<={{'${#unlockcodes[@]}'}} ; i=i+1 ))
    do
      seq=$(($i % 14))
      if [ $seq -eq 0 ]; then
         continue
      fi

      if [ $seq -eq 13 ]; then
         status=$(echo ${unlockcodes[$i]} | awk -F "\"" '{print $2}')
         code=$(echo ${unlockcodes[$i]} | awk -F "[><]" '{print $2}')
         isBefore=$(($(date -d"${startDate}" +%s)-$(date +%s)))
         isAfter=$(($(date -d"${expirationDate}" +%s)-$(date +%s)))

         if [ $status = "NOT_UNLOCKED" ]; then
            error "code $code is not unlocked"
         fi

         if [ $isBefore -lt 0 -a $isAfter -gt 0 -a $status = "OK" ]; then
            if [ $type = "VALIDATION" ]; then
                validateresult=1
            fi
            if [ $type = "SUPPLEMENTARY" ]; then
               supplementaryresult=1
            fi
             if [ $type = "GEO_STANDARD" ]; then
                geocodingresult=1
            fi
         fi
         continue
      fi

      value=$(echo ${unlockcodes[$i]} | awk -F "=" '{print $2}' | sed 's/\"//g')

      if [ $seq -eq 2 ]; then
          type=$value
      fi
      if [ $seq -eq 4 ]; then
          startDate=$value
      fi
      if [ $seq -eq 5 ]; then
          expirationDate=$value
      fi
    done

    if [ $validateresult -eq 0 ]; then
        error "No unlock code is valid for VALIDATION"
    fi
    if [ $supplementaryresult -eq 0 ]; then
        error "No unlock code is valid for SUPPLEMENTART"
    fi
    if [ $geocodingresult -eq 0 ]; then
         error "No unlock code is valid for GEO_STANDARD"
    fi
}

function restfulEndpointTest {
     restfulEndPoints=(validatedAddress certifiedAddress looselyValidatedAddress addressSuggestions fastCompletionAddress)
     for restfulEndpoint in ${restfulEndpoints[*]}
     do
       url="http://{{ inventory_hostname }}:{{ port }}/match/${restfulEndPoint}/documentation"
       response=$(curl --header "X-HP-Application-Process-UID: w-mdcp:prd-http" -s -i ${url})
       if ! echo "${response}" | grep -q "HTTP/1.1 200"
       then
           error "Restful ${restfulEndPoint} endpoint test did not return 200 status."
       fi
     done
}

function soapEndpointTest {
    response=$(curl --header "Content-Type: text/xml;charset=UTF-8" --header "X-HP-Application-Process-UID: w-mdcp:prd-http" -s -i http://{{ inventory_hostname }}:{{ port }}/legacy-match/address/v1?wsdl)
    if ! echo "${response}" | grep -q "HTTP/1.1 200"
    then
      error "Soap endpoint test did not return 200 status."
    fi
}

function restValidationTest {
  restfulEndPoints=(validatedAddress certifiedAddress looselyValidatedAddress addressSuggestions fastCompletionAddress)
  for restfulEndPoint in ${restfulEndPoints[*]}
  do
    url="http://{{ inventory_hostname }}:{{ port }}/match/${restfulEndPoint}?country1=US&deliveryAddressLine1=745+Riverhaven+Drive&characterScriptDetectionIndicator=false&postalCode1=30024"
    response=$(curl --header "X-HP-Application-Process-UID: w-mdcp:prd-http" -s -i ${url})
    if ! echo "${response}" | grep -q "HTTP/1.1 200"
    then
      error "Restful ${restfulEndPoint} Validation test did not return 200 status."
    fi
  done
}

function soapValidationTest {
    cd {{ casfw_home }}
    response=$(curl --header "Content-Type: text/xml;charset=UTF-8" --header "X-HP-Application-Process-UID: w-mdcp:prd-http" --data @soap_envelope.xml -s -i http://{{ inventory_hostname }}:{{ port }}/legacy-match/address/v1?wsdl)
    if ! echo "${response}" | grep -q "HTTP/1.1 200"
    then
      error "Soap Validation test did not return 200 status."
    fi
}

$userinput