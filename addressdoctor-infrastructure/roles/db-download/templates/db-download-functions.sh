#!/bin/bash

HOME="/tmp"
userinput="$1"

jdkpath="{{ casfw_home }}/software/openjdk"

function error {
    local message=$1
    echo $1 >&2
    exit -1
}

function checkDiskSpace {
    mountDisk=$(df -hP {{ casfw_home }} | tail -1 | awk '{print $6}');
    leftSpace=$(df -mP $mountDisk | tail -1 | awk '{print $4}');

    # the left disk space should not less than 40G
    if [ "$leftSpace" -lt 40960 ]; then
        error "The left space of disk $mountDisk is NOT enough: less than 40G";
    fi
}

function initialADMClientFolder {
	if [[ -d {{ adm_client_folder }} ]]; then
		mv {{ adm_client_folder }} {{ adm_client_folder }}_"$(date +"%Y-%m-%d-%H:%M:%S")"
	fi

	mkdir -p {{ adm_client_folder }}
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

    rm -f openjdk-java-{{ jdk_verion }}-linux-x64.tar.gz
}

function prepareDownloadtool {
    cd {{ adm_client_folder }}
    jar xf Downloadtool-{{ downloadtool_version }}.zip
    jar xf download-{{ download_xml_version }}.zip
    rm -f Downloadtool-{{ downloadtool_version }}.zip
    rm -f download-{{ download_xml_version }}.zip
}

function downloadDB {
    if [ ! -e "${JAVA_HOME}/bin/java" ]; then
        export JAVA_HOME="$jdkpath"/openjdk-java-{{ jdk_verion }}
    fi
    
    cd {{ adm_client_folder }}
    mkdir Downloads
    xargs -a {{ casfw_home }}/db-download-args.txt ${JAVA_HOME}/bin/java > /dev/null
}

function unzipDBFiles {
	# check if the target db folder exist or not
	if [[ -d {{ db_folder }} ]]; then
        mv {{ db_folder }} {{ db_folder }}_"$(date +"%Y-%m-%d-%H:%M:%S")"
    fi
    mkdir -p {{ db_folder }}

    # change to directory of the zip files
	cd {{ adm_client_folder }}/Downloads
    
	# find the prefix of duplicated db files
	duplicatedFilePrefix=$(ls | awk -F "_" '{print $2}' | uniq -d)

	# get the number of the duplicated files
    num=0
    for i in ${duplicatedFilePrefix[*]}
    do
        num=$(($num+1))
    done

    # handle the duplicated files
    if [[ $num -gt 0 ]]; then
        for filePrefix in ${duplicatedFilePrefix[*]}
        do
            # back up the old files which product id is 01, for example: DB5_SGP5BI_01_150201.zip
            oldFiles=($(ls | grep $filePrefix | grep _01_))
            for oldFile in ${oldFiles[*]}
            do
                # back up the old db files
                mv $oldFile $oldFile"_bak"
            done
        done
    fi

#    # handle the duplicated files
#    if [[ $num -gt 0 ]]; then
#        for filePrefix in ${duplicatedFilePrefix[*]}
#        do
#            # find out the latest date of the duplicated zip files
#            latestDate=($(ls | grep $filePrefix | awk -F "_" '{print $4}' | awk -F "." '{print $1}' | sort -n | tail -1))
            
#            # find out the old zip db files
#            oldFiles=($(ls | grep $filePrefix | grep $latestDate -v))
#            for oldFile in ${oldFiles[*]}
#            do
#                # back up the old db files
#                mv $oldFile $oldFile"_bak"
#            done
#        done
#    fi

    # unzip all the zip db files to db stage folder
    # clear unzip output log
    # unzip "*.zip" -d {{ db_folder }} > /dev/null
    # Use jar command to unzip *.zip files
    dbFileList=$(ls *zip)
    cd {{ db_folder }}
    for zipFile in ${dbFileList[*]}
    do
        jar xf {{ adm_client_folder }}/Downloads/$zipFile
    done
}

function finalCleanup {
	cd {{ casfw_home }}
    rm -f db-download*.sh
    rm -f db-download*.txt
}

$userinput