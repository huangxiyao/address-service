#!/bin/bash

HOME="/opt/casfw"
userinput="$1"
lb_url="$2"
health_check_url="$3"

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

function jrunscriptTest {
    checkurl="https://${lb_url}/${health_check_url}"
    status=$(jrunscript -e "print(new java.net.URL(\"${checkurl}\").openConnection().getResponseCode())")

    if [[ ${status} -ne 200 ]]
    then
      error "$checkurl - jrunscript command test did not return 200 status."
    fi

    echo "$checkurl - SUCCESS with jrunscript command test"
}

function curlTest {
    checkurl="https://${lb_url}/match/validatedAddress?country1=US&deliveryAddressLine1=\"11925 Jones RD\"&locality1=Houston&postalCode1=77070&province1=TX"
    status=$(curl -o "/dev/null" -s -w "%{http_code}" -H "X-HP-Application-Process-UID:hpit:CD-TEST" "${checkurl}")
    if [[ ${status} -ne 200 ]]
    then
      error "$checkurl - curl test did not return 200 status."
    fi

    echo "$checkurl - SUCCESS with curl command test."
}

function opensslTest {
    response=$(echo -e "HEAD / HTTP/1.0\r\nHost: ${lb_url}\r\n\r\n" | openssl s_client -servername ${lb_url} -connect ${lb_url}:443 -state)
    if ! echo "${response}" | grep -q "Verify return code: 0 (ok)"
    then
      error "$response - SSL Check Failed with openssl command."
    fi

    echo "SSL Check SUCCESS with openssl command."
}

$userinput