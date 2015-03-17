#!/bin/bash

HOME="/opt/casfw"
userinput="$1"

function error {
    local message=$1
    echo $1 >&2
    exit -1
}

function instanceRunningStatus {
    pid_file="{{ casfw_home }}/current/{{ data_match_instance }}/var/tomcat-ad.pid"
    if [ -f ${pid_file} ]; then
      s=$(printf " %s " $(ps -e | grep $(cat ${pid_file})) | awk '{ print $1 }')
      if [ -n "$s" ]; then
        echo "tomcat-ad running $s"
      fi
    fi
}

function stopInstanceProcess {
    cd {{ casfw_home }}
    if [ -f './current/{{ data_match_instance }}/bin/tomcat-ad.sh' ]; then
      bash ./current/{{ data_match_instance }}/bin/tomcat-ad.sh stop -force
    fi
}

function initialCleanup {
    cleanupInstance
    cleanupCurrentLink
}

function cleanupInstance {
    rm -rf {{ casfw_home }}/{{ data_match_instance }}/data-match-*
}

function cleanupCurrentLink {
    rm -f {{ casfw_home }}/current/{{ data_match_instance }}
}

function installcdi {
    cd {{ casfw_home }}
    xargs -a data-match-cdi-args.txt sh data-match-installer-{{ data_match_release_version }}.cdi
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

function soapValidationTest {
    cd {{ casfw_home }}
    checkurl="http://{{ inventory_hostname }}:{{ port }}/legacy-match/address/v1?wsdl"
    response=$(curl --header "Content-Type: text/xml;charset=UTF-8" --header "X-HP-Application-Process-UID: w-mdcp:prd-http" --data @soap_envelope.xml -s -i ${checkurl})
    if ! echo "${response}" | grep -q "HTTP/1.1 200"
    then
      error "Soap Validation test did not return 200 status."
    fi

    echo "$checkurl - SUCCESS"
}

function finalCleanup {
    cd {{ casfw_home }}
    rm -f data-match-functions.sh
    rm -f data-match-cdi-args.txt
    rm -f soap_envelope.xml
}

$userinput