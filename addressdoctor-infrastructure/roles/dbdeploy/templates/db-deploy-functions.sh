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

# Update DB Symlink
function updateDBSymLink {
    cd {{ casfw_home }}/address-doctor/databases
    rm -rf all
    ln -sf {{ db_target_folder }} all
}

function finalCleanup {
	cd {{ casfw_home }}
    rm -f db-deploy*.sh
}

$userinput