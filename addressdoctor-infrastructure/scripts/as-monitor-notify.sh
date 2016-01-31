#!/bin/sh

# ================================================================================
# Flowdock
# ================================================================================

ENVIRONMENT="$1"
UPPERENV=$(echo "$ENVIRONMENT" | tr '[[:lower:]]' '[[:upper:]]')

isTest="$2"
FLOW_TOKEN="f15e4c48063baa75b9617d297f60a372" # CAS Team Test Flow
if [[ "$isTest" == "" ]]
then
    FLOW_TOKEN="0c0eb8d69dbebae357df44680f7b855d" # CAS Team Flow
fi

RESULTFILE="as-monitor-result.txt";
FAILEDRECORDS=""
TABLE=""

if [[ -f $RESULTFILE ]]
then
    FAILEDRECORDS=$(cat $RESULTFILE | grep "${JOB_NAME}-${BUILD_NUMBER}" | sed "s/${JOB_NAME}-${BUILD_NUMBER} //g")
fi

function retrieveFailedRecords {
    TABLE="<table border='1'><tr><th>Failed Url</th><th>Status Code</th></tr>";

while read record
do
    url=$(echo ${record} | awk '{print $1}');
    status=$(echo ${record} | awk '{print $2}');
    TABLE=${TABLE}"<tr><td><a href="${url}">"${url}"</a></td><td>"${status}"</td></tr>";
done << EOF
$FAILEDRECORDS
EOF

    TABLE=${TABLE}"</table>";
}

function postFailedRecordsToFlowdockInbox {
    curl --silent \
         --header "Accept: application/json" \
         --form "flow_token=$FLOW_TOKEN" \
         --form "event=activity" \
         --form "author[name]=Jenkins" \
         --form "author[avatar]=http://jenkins-ci.org/sites/default/files/images/headshot.png" \
         --form "title= <a href=${BUILD_URL}console>${JOB_NAME}-${BUILD_NUMBER} Console Output</a>" \
         --form "tags=AS-Monitoring" \
         --form "external_thread_id=extract:as:monitor:$UPPERENV" \
         --form "thread[title]=$JOB_NAME" \
         --form "thread[status][color]=orange" \
         --form "thread[status][value]=failure" \
         --form "body= ${TABLE}" \
         "https://api.flowdock.com/messages" > /dev/null
}

if [[ $FAILEDRECORDS != "" ]]
then
    echo "Sending out the FAILED Monitor notification..."
    retrieveFailedRecords
    postFailedRecordsToFlowdockInbox
    exit 1
else
    echo "Monitors are SUCCESS!"
    exit 0
fi
