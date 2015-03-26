#!/bin/bash

HOME="/opt/casfw"
userinput="$1"
lb_url="$2"

function error {
    local message=$1
    echo $1 >&2
    exit -1
}

function soapValidationTest {
    cd /tmp

    checkurl="https://${lb_url}/legacy-match/address/v1?wsdl"
    response=$(curl --header "Content-Type: text/xml;charset=UTF-8" --header "X-HP-Application-Process-UID: w-mdcp:prd-http" --data @soap_envelope.xml -s -i ${checkurl})
    if ! echo "${response}" | grep -q "HTTP/1.1 200"
    then
      error "Soap Validation test did not return 200 status."
    fi

    echo "$checkurl - SUCCESS with soap data: "
    echo "$(cat soap_envelope.xml)"
}

function finalCleanup {
    cd /tmp
    rm -f acceptance-test-functions.sh
    rm -f soap_envelope.xml
}

$userinput