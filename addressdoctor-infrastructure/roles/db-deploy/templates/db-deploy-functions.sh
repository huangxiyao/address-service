#!/bin/bash

HOME="/opt/casfw"
userinput="$1"

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

# initial db latest version zip folder
function initialDBLatestVersionZipFolder {
    if [[ -d {{ db_target_folder }}/{{ db_latest_version }}_zip ]]; then
        mv {{ db_target_folder }}/{{ db_latest_version }}_zip {{ db_target_folder }}/{{ db_latest_version }}_zip_"$(date +"%Y-%m-%d-%H:%M:%S")"
    fi
    
    mkdir -p {{ db_target_folder }}/{{ db_latest_version }}_zip
}

# initial db latest version folder
function initialDBLatestVersionFolder {
    if [[ -d {{ db_target_folder }}/{{ db_latest_version }} ]]; then
        mv {{ db_target_folder }}/{{ db_latest_version }} {{ db_target_folder }}/{{ db_latest_version }}_"$(date +"%Y-%m-%d-%H:%M:%S")"
    fi
    
    mkdir -p {{ db_target_folder }}/{{ db_latest_version }}
}

function unzipDBFiles {
    # change to directory of the zip files
    cd {{ db_target_folder }}/{{ db_latest_version }}_zip

    # unzip all the zip db files to db latest version folder
    # clear unzip output log
    unzip "*.zip" -d {{ db_target_folder }}/{{ db_latest_version }} > /dev/null
}

# Update DB Symlink
function updateDBSymLink {
    cd {{ db_target_folder }}
    rm -f all
    ln -sf {{ db_latest_version }} all
}

function finalCleanup {
	cd {{ casfw_home }}
    rm -f db-deploy*.sh
}

$userinput