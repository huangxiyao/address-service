#!/bin/bash

HOME="/opt/casfw"
userinput="$1"

function checkDatabasesLoaded {
	cd {{ casfw_home }}/address-doctor/databases/all
	databases=($(ls .))
	cd {{ casfw_home }}/data-match2/data-match-2015.02.01/var/log/data-match-web
	result=1
	for ((i=0;i<${#databases[*]};i++))
	do
		if ! grep -q ${databases[${i}]} ad-engine.log
		then
			if [ $result -eq 1 ]
			then
			echo "NOT All Databases Loaded:"
			fi
			echo ${databases[${i}]}
			result=0
		fi
	done
	if [ $result -eq 1 ]
	then
		echo "All Databases Loaded"
	fi	
}

$userinput