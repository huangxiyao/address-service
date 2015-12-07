#!/bin/bash

HOME="/opt/casfw"
userinput=$1
userId=`whoami`

function serverInitialValidation {
    if [ -f /etc/init.d/casfw ]; then
        echo -ne "Installed"
    else
        echo -ne "Not installed"
    fi
}

function serverInitialSetup {
    if [ ! -f /etc/init.d/casfw ]; then
        cp /tmp/init-casfw /etc/init.d/casfw
        chmod 755 /etc/init.d/casfw
        echo "casfw script copied to /etc/init.d/"
    fi
    if [[ ! -h "/etc/rc3.d/K98casfw" ]]; then
        ln -s /etc/init.d/casfw /etc/rc3.d/K98casfw
        ln -s /etc/init.d/casfw /etc/rc3.d/S98casfw
        echo "rc3.d restart links created"
    fi
}

function finalCleanup {
    rm /tmp/init-casfw
    rm /home/$userId/auto-start-functions.sh
}

$userinput
