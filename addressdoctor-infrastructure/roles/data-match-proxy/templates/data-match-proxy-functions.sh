#!/bin/bash

HOME="/opt/casfw"
userinput=$1
datamatchdirname="data-match-{{ data_match_release_version }}"
datamatchcdifile="data-match-installer-{{ data_match_release_version }}.cdi"

function copyCasfwConfScript {
    if [ -d /opt/cloudhost ]; then
		copyScript         
    fi
}

function copyScript {
	if [ ! -f /etc/httpd/conf.d/casfw.conf ]; then
        /opt/pb/bin/pbrun cp {{ casfw_home }}/casfw.conf /etc/httpd/conf.d/
        /opt/pb/bin/pbrun chmod 644 /etc/httpd/conf.d/casfw.conf
    fi
}

function restartCloudApacheInstance {
	sudo service httpd restart
}

function finalCleanup {
    cd {{ casfw_home }}
    rm -f data-match-proxy-functions.sh
    rm -f casfw.conf
}

function checkDataMatchInstallation {
    if [[ -f {{ casfw_home }}/$datamatchcdifile && -d {{ casfw_home }}/data-match1/$datamatchdirname && -d {{ casfw_home }}/data-match2/$datamatchdirname && -d {{ casfw_home }}/data-match3/$datamatchdirname ]]; then
        echo "Install"
    fi
}

$userinput
