#!/bin/bash

HOME="/opt/casfw"
userinput="$1"

jdkpath="{{ casfw_home }}/software/openjdk"

function error {
    local message=$1
    echo $1 >&2
    exit -1
}

function checkDiskSpace {
        mountDisk=$(df -hP {{ casfw_home }}| tail -1 | awk '{print $6}');
        leftSpace=$(df -mP $mountDisk | tail -1 | awk '{print $4}');

        # the left disk space should not less than 40G
        if [ "$leftSpace" -lt 40960 ]; then
                error "The left space of disk $mountDisk is NOT enough: less than 40G";
        fi
}

function initialADMClientFolder {
	if [[ -d {{ adm_client_folder }} ]]; then
		mv {{ adm_client_folder }} {{ adm_client_folder }}_"$(date +"%Y-%m-%d-%H:%M:%S")"
	else
		mkdir -p {{ adm_client_folder }}
	fi
}	

function javahomeValidation {
	if [ -e "${JAVA_HOME}/bin/java" ]; then
		echo -ne "Installed"
	elif [ -e "$jdkpath"/openjdk-java-{{ jdk_verion }}/bin/java ]; then
		echo -ne "Existed"
	else
		echo -ne "Not installed"
	fi
}

function installJDK {
	cd {{ casfw_home }}

	if [ ! -d "$jdkpath" ]; then
		mkdir -p "$jdkpath"
	fi

	if [ ! -e "$jdkpath"/openjdk-java-{{ jdk_verion }} ]; then
		tar -zxvf openjdk-java-{{ jdk_verion }}-linux-x64.tar.gz -C "$jdkpath"
	fi

    rm -rf openjdk-java-{{ jdk_verion }}-linux-x64.tar.gz
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
    xargs -a {{ casfw_home }}/db-download-args.txt "$jdkpath"/openjdk-java-{{ jdk_verion }}/bin/java
}

function finalCleanup {
	cd {{ casfw_home }}
    rm -f db-download*.sh
    rm -f db-download*.txt
}

$userinput