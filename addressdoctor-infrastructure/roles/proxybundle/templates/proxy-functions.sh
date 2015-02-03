#!/bin/bash

HOME="/opt/casfw"
userinput="$1"

jdkpath="{{ casfw_home }}/software/openjdk"

function initialCleanup {
    cd {{ casfw_home }}
    rm -rf proxy-bundle
    rm -rf proxy-bundle*.cdi
}

function cleanupProxyBundle {
	rm -rf {{ casfw_home }}/proxy-bundle*
}

function javahomeValidation {
	if [ -e "${JAVA_HOME}/bin/java" ]; then
		echo -ne "Installed"
	else
		echo -ne "Not installed"
	fi
}

function installJDK {
	cd {{ casfw_home }}

	if [ ! -d "$jdkpath" ]; then
		mkdir -p "$jdkpath"
	fi

	if [ -e "$jdkpath"/openjdk-java-{{ jdk_verion }} ]; then
		rm -rf "$jdkpath"/openjdk-java-{{ jdk_verion }}
	fi

	tar -zxvf openjdk-java-{{ jdk_verion }}-linux-x64.tar.gz -C "$jdkpath"

    rm -rf openjdk-java-{{ jdk_verion }}-linux-x64.tar.gz
}

function installProxyBundleCdi {
	if [ ! -e "${JAVA_HOME}/bin/java" ]; then
		export JAVA_HOME="$jdkpath"/openjdk-java-{{ jdk_verion }}
    	export PATH=$JAVA_HOME/bin:$PATH
    fi

    cd {{ casfw_home }}
    sh proxy-bundle-installer-*.cdi -d {{ casfw_home }} -e {{ release_env }}
}

function createProxyBundleLink {
    cd {{ casfw_home }}
    ln -sf proxy-bundle-{{ proxy_bundle_version }} proxy-bundle
}

function validateApacheConf {
	if [ -e "{{ httpd_confd_path }}/casfw.conf" ]; then
		echo -ne "Existed"
	else
		echo -ne "Not existed"
	fi
}

function copyCasfwConfScript {
    if [ -d /opt/cloudhost ]; then
		copyScript         
    fi
}

function copyScript {
	if [ ! -f {{ httpd_confd_path }}/casfw.conf ]; then
        /opt/pb/bin/pbrun cp {{ casfw_home }}/casfw.conf {{ httpd_confd_path }}
        /opt/pb/bin/pbrun chmod 644 {{ httpd_confd_path }}/casfw.conf
    fi
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

function restartCloudApacheInstance {
	sudo service httpd restart
}

function finalCleanup {
    cd {{ casfw_home }}
    rm -f *.conf
    rm -f *.sh
}

$userinput
