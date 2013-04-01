#!/bin/bash

# Scan the PRO logs for a given day.
# Construct curl commands and execute it against ITG environment.
# Log the number of successful transactions and the number of transactions that crashed address doctor.

# $1:PRO_LOG_FILE
# $2:RESULT_LOG_FILE
# $3:ITG_SERVER_NAME
# $4:SERVER_PORT
# usage
function printUsageAndExit(){
    echo -e "\nUsage: sh $0 PRO_LOG_FILE RESULT_LOG_FILE ITG_SERVER_NAME SERVER_PORT\n";
    exit 1;
}

# check parameters
if [ $# -lt 3 -o $# -gt 4 ]; then
    printUsageAndExit
fi

# check PRO_LOG_FILE if it exists
if [ ! -f "$1" ]; then
    echo -e "$1 does not exist \n";
    exit 1;
elif [ ! -r "$1" ]; then
    echo -e "$1 can not read \n";
    exit 1;
fi

# make sure the RESULT_LOG_FILE is empty
if [ -f "$2" ]; then
    if [ -s "$2" ]; then
        if [ -w "$2" ]; then
            cat /dev/null > $2;
        else
            rm -rf $2;
        fi
    fi
fi

# check SERVER_PORT
if [ -z "$4" ]; then
    # default server port 80
    url="http://"$3":80/match/validatedAddress?";
elif [[ "$4" =~ "^[0-9]+$" ]]; then
    url="http://"$3":"$4"/match/validatedAddress?";
else
    printUsageAndExit;
fi

# number of successful transactions
number_success=0;
# number of transactions that crashed address doctor
number_failure=0;
# count entry lines
count=0;

# escape the special characters in the url
function encodeUrl(){
    echo "$1" | sed -e 's|%|%25|g' \
    -e 's| |%20|g' \
    -e 's|!|%21|g' \
    -e 's|#|%23|g' \
    -e 's|\$|%24|g' \
    -e 's|&|%26|g' \
    -e "s|'|%27|g" \
    -e 's|(|%28|g' \
    -e 's|)|%29|g' \
    -e 's|*|%2A|g' \
    -e 's|+|%2B|g' \
    -e 's|,|%2C|g' \
    -e 's|/|%2F|g' \
    -e 's|:|%3A|g' \
    -e 's|;|%3B|g' \
    -e 's|=|%3D|g' \
    -e 's|?|%3F|g' \
    -e 's|@|%40|g' \
    -e 's|\[|%5B|g' \
    -e 's|]|%5D|g'
}

# read log file line by line
outfile=`cat $1 | grep ENTRY`
while read entry_line;
do
    address_query=`echo "${entry_line}" | awk -F "[" '{print $4}' | awk -F "]" '{print $1}'`;
    OLD_IFS="$IFS";
    IFS="=";
    arr=($address_query);
    length=${#arr[@]};
    for ((index=0;index < length;index++))
    do
        # get keys
        if [ $index -eq 0 ]; then
            arr_key[index]=${arr[index]};
        elif [ $index -lt $(($length-1)) ]; then
            arr_key[index]=`echo ${arr[index]##*,\ }`;
        fi

        # get values
        if [ $index -gt 0 -a $index -lt $(($length-1)) ]; then
            arr_value[$(($index-1))]=`echo ${arr[index]%,\ *}`;
        elif [ $index -ne 0 -a $index -eq $(($length-1)) ]; then
            arr_value[$(($index-1))]=${arr[index]};
        fi
    done

    len_key_value=${#arr_key[@]};
    address_query_url="";
    # assemble url 
    for ((index=0;index < len_key_value;index++))
    do
        # escape special characters in url
        arr_value[index]=$(encodeUrl ${arr_value[index]});

        if [ $index -eq $(($len_key_value-1)) ]; then
            address_query_url=${address_query_url}${arr_key[index]}\=${arr_value[index]};
            break;
        fi
        
        address_query_url=${address_query_url}${arr_key[index]}\=${arr_value[index]}\&;
    done

    # clear arr_key arr_value
    unset arr_key;
    unset arr_value;

    http_url=${url}${address_query_url};
    http_status=$(curl -o "/dev/null" -s -w "%{http_code}" --connect-timeout 10 --retry 2 --retry-delay 60 \
    -H "X-HP-Application-Process-UID:w-mdcp:prd-http" "$http_url");
    if [ $http_status -eq 200 ]; then
        number_success=$(($number_success+1));
    else
        number_failure=$(($number_failure+1));   
        # restore failure url
        echo "$http_url" >> $2;
    fi
  
    count=$(($count+1));
    if [ $(($count % 10)) -eq 0 ]; then
        echo -e "[INFO]$(date +"%Y-%m-%d %T") Have already read $count ENTRY lines. Program is running, please keep waiting...";
    fi 

done << EOF 
$outfile
EOF

echo -e "[INFO]$(date +"%Y-%m-%d %T") The program have already finished reading $count ENTRY lines in the file $1.\n";
echo "number of successful transactions is $number_success." >> $2;
echo "number of transactions that crashed address doctor is $number_failure." >> $2;
