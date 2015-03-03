#!/bin/bash

HOME="/opt/casfw"
userinput="$1"

jdkpath="{{ casfw_home }}/software/openjdk"

function cleanCdi {
    cd {{ casfw_home }}
    rm -f proxy-bundle*.cdi
}

function initialCleanup {
    cd {{ casfw_home }}
    rm -rf proxy-bundle
}

function cleanupProxyBundle {
	#rm -rf {{ casfw_home }}/proxy-bundle*
	cd {{ casfw_home }}
	find . -maxdepth 1  -type d  -name "proxy-bundle-*" -exec rm -rf {} \;
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

	if [ ! -e "$jdkpath" ]; then
		mkdir -p "$jdkpath"
	fi

	if [ ! -e "$jdkpath"/openjdk-java-{{ jdk_verion }} ]; then
		tar -zxvf openjdk-java-{{ jdk_verion }}-linux-x64.tar.gz -C "$jdkpath"
	fi

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

function restartCloudApacheInstance {
	sudo service httpd restart
}

function finalCleanup {
    cd {{ casfw_home }}
    rm -f casfw.conf
    rm -f proxy-*.sh
}

$userinput
