#!/bin/bash

HOME="/opt/casfw"
userinput="$1"

function initialCleanup {
    cd {{ casfw_home }}
    rm -rf proxy-bundle
    rm -rf proxy-bundle*.cdi
}

function cleanupProxyBundle {
	rm -rf {{ casfw_home }}/proxy-bundle*
}

function installProxyBundleCdi {
	#TODO: Set JAVA HOME, need to remove in future
	export JAVA_HOME=/opt/mount/app/java
    export PATH=$JAVA_HOME/bin:$PATH

    cd {{ casfw_home }}
    sh proxy-bundle-installer-*.cdi -d {{ casfw_home }} -e {{ release_env }}
}

function createProxyBundleLink {
    cd {{ casfw_home }}
    ln -sf proxy-bundle-{{ proxy_bundle_version }} proxy-bundle
}

function startApacheInstance {
	/opt/webhost/whaeng/bin/start_apache {{ apache_instance }}
}

function stopApacheInstance {
	/opt/webhost/whaeng/bin/stop_apache {{ apache_instance }}
}

function restartApacheInstance {
	stopApacheInstance
	startApacheInstance
}

function startCloudApacheInstance {
	sudo monit start httpd
}

function stopCloudApacheInstance {
	sudo monit stop httpd
}

function restartCloudApacheInstance {
	stopCloudApacheInstance
	startCloudApacheInstance
}

function finalCleanup {
    cd {{ casfw_home }}
    rm -rf proxy-bundle*.cdi
    rm -f *.sh
}

$userinput
