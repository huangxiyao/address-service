#!/bin/bash

HOME="/opt/casfw"
userinput="$1"

function checkDatabasesLoaded {
	cd {{ casfw_home }}/address-doctor/databases/all
	databases=($(ls .))
	cd {{ casfw_home }}/{{ data_match_instance }}/data-match-{{ data_match_release_version }}}/var/log/data-match-web
	result=1
	for ((i=0;i<${#databases[*]};i++))
	do
		filename=${databases[${i}]}
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

$userinput