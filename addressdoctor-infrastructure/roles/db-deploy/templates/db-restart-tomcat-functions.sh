#!/bin/bash

HOME="/opt/casfw"
userinput="$1"

function error {
    local message=$1
    echo $1 >&2
    exit -1
}

function stopTomcatInstance {
    cd {{ casfw_home }}
    bash current/{{ data_match_instance }}/bin/tomcat-ad.sh stop -force
}

function startTomcatInstance {
    cd {{ casfw_home }}
    bash current/{{ data_match_instance }}/bin/tomcat-ad.sh start
}

# wait for data-match databases load is finished
# polling check engine log to make sure the db files are loaded and tomcat start finised
function waitDatabasesLoadFinished {
    cd {{ casfw_home }}
    time=0
    while [ "1" = "1" ]; do
        sleep 10
        cat current/{{ data_match_instance }}/var/log/data-match-web/ad-engine.log | tail -2 | head -1 | grep "</GetConfig>" > /dev/null
        if [[ $? -eq 0 ]]; then
            echo -ne "Databases Load Finished"
            break
        fi
        time=$(( $time + 1))
        if [[ $time -eq 60 ]]; then
             error -ne "Databases Load got time out after 10 minutes"
        fi
    done
}

function checkDatabasesLoaded {
    cd {{ casfw_home }}/current/{{ data_match_instance }}/var/log/data-match-web

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

function soapValidationTest {
    cd {{ casfw_home }}
    checkurl="http://{{ inventory_hostname }}:{{ port }}/legacy-match/address/v1?wsdl"
    response=$(curl --header "Content-Type: text/xml;charset=UTF-8" --header "X-HP-Application-Process-UID: w-mdcp:prd-http" --data @soap_envelope.xml -s -i ${checkurl})
    if ! echo "${response}" | grep -q "HTTP/1.1 200"
    then
      error "Soap Validation test did not return 200 status."
    fi

    echo "$checkurl - SUCCESS with soap data: "
    echo "$(cat soap_envelope.xml)"
}

function finalCleanup {
    cd {{ casfw_home }}
    rm -f db-restart-tomcat*.sh
    rm -f soap_envelope.xml
}

$userinput