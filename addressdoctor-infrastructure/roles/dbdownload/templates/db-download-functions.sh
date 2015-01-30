#!/bin/bash

HOME="/opt/casfw"
userinput="$1"

function initial {
	if [[ -d {{ adm_client_folder }} ]]; then
		mv {{ adm_client_folder }} {{ adm_client_folder }}_"$(date +"%Y-%m-%d-%H:%M:%S")"
	else
		mkdir -p {{ adm_client_folder }}
	fi

	if [[ -d {{ software_dir }} ]]; then 
		rm -rf {{ software_dir }}/*
	else
		mkdir -p {{ software_dir }}
	fi
}	

function installJava7 {
	cd {{ software_dir }}
	tar -zxvf oracle-java-{{ oracle_java_version }}-linux-x64.tar.gz
}

function prepareDownloadtool {
    cd {{ adm_client_folder }}
    unzip Downloadtool-{{ downloadtool_version }}.zip
    unzip download-{{ download_xml_version }}.zip
    rm -rf Downloadtool-{{ downloadtool_version }}.zip
    rm -rf download-{{ download_xml_version }}.zip
}

function downloadDB {
    cd {{ adm_client_folder }}
    mkdir Downloads
    {{software_dir}}/oracle-java-{{ oracle_java_version }}/bin/java -Dhttps.proxyHost=web-proxy.austin.hp.com -Dhttps.proxyPort=8088 -jar Downloadtool.jar -ng -un:santhosh.chandan@hp.com -pd:Anagha@123
}

function finalCleanup {
	cd {{ casfw_home }}
    rm -f db-download-functions.sh
}

$userinput