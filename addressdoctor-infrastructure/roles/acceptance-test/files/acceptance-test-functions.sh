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
    checkurl="http://${lb_url}/legacy-match/address/v1?wsdl"
    response=$(curl --header "Content-Type: text/xml;charset=UTF-8" --header "X-HP-Application-Process-UID: w-mdcp:prd-http" --data @- -s -i ${checkurl} << EOF
 <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:loc="http://localhost/">
    <soapenv:Header/>
    <soapenv:Body>
       <loc:standardizeDiscreteAddress>
          <loc:DistInput>
            <loc:string></loc:string>
            <loc:string></loc:string>
            <loc:string>100 N LOS ANGELES ST</loc:string>
            <loc:string></loc:string>
            <loc:string></loc:string>
            <loc:string></loc:string>
            <loc:string>"LOS ANGELES"</loc:string>
            <loc:string></loc:string>
            <loc:string></loc:string>
            <loc:string>CA</loc:string>
            <loc:string></loc:string>
            <loc:string>90012</loc:string>
            <loc:string>US</loc:string>
          </loc:DistInput>
       </loc:standardizeDiscreteAddress>
    </soapenv:Body>
 </soapenv:Envelope>
EOF
)
    if ! echo "${response}" | grep -q "HTTP/1.1 200"
    then
      error "Soap Validation test did not return 200 status."
    fi

    echo "$checkurl - SUCCESS with soap data: "
}

$userinput