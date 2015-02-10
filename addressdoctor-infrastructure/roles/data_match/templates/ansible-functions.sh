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

function checkDatabasesLoaded { 
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

function restfulEndpointTest {
    response=$(curl --header "X-HP-Application-Process-UID: w-mdcp:prd-http" -s -i http://{{ inventory_hostname }}:{{ port }}/match/validatedAddress?country1=US&deliveryAddressLine1=745+Riverhaven+Drive&characterScriptDetectionIndicator=false&postalCode1=30024)
    if ! echo "${response}" | grep -q "HTTP/1.1 200"
       then
         error "Restful Endpoint test did not return 200 status."
    fi
}

function soapEndpointTest {
    response=$(curl --header "Content-Type: text/xml;charset=UTF-8" --header "X-HP-Application-Process-UID: w-mdcp:prd-http" --data @soap_envelope.xml -s -i http://C0004714.itcs.hp.com:{{ port }}/legacy-match/address/v1?wsdl)
    echo "${response}"
}

$userinput
