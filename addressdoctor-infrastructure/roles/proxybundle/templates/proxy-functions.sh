#!/bin/bash

HOME="/opt/casfw"
userinput="$1"

proxydirname="proxy-bundle-{{ proxy_bundle_version }}"
proxycdifile="proxy-bundle-installer-{{ proxy_bundle_version }}"
jdkpath="{{ casfw_home }}/software/openjdk"

function checkProxyInstallation {
	if [[ -d {{ casfw_home }}/$proxydirname ]]; then
		echo -ne "Installed"
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

	if [ ! -e "$jdkpath" ]; then
		mkdir -p "$jdkpath"
	fi

	if [ ! -e "$jdkpath"/openjdk-java-{{ jdk_verion }} ]; then
		tar -zxvf openjdk-java-{{ jdk_verion }}-linux-x64.tar.gz -C "$jdkpath"
	fi

    rm -f openjdk-java-{{ jdk_verion }}-linux-x64.tar.gz
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

function initialCleanup {
    cleanupProxySymbolLink
    cleanupProxyBundle
    cleanupOldCdi
}

function cleanupProxySymbolLink {
	cd {{ casfw_home }}
    rm -f proxy-bundle
}

function cleanupProxyBundle {
	cd {{ casfw_home }}
	find . -maxdepth 1  -type d  -name "proxy-bundle-*" -exec rm -rf {} \;
}

function cleanupOldCdi {
    cd {{ casfw_home }}
    find . -name "proxy-bundle-installer-*.cdi" | grep -v {{ proxy_bundle_version }} | xargs rm -f
}

function installProxyBundleCdi {
	if [ ! -e "${JAVA_HOME}/bin/java" ]; then
		export JAVA_HOME="$jdkpath"/openjdk-java-{{ jdk_verion }}
    	export PATH=$JAVA_HOME/bin:$PATH
    fi

    cd {{ casfw_home }}
    sh proxy-bundle-installer-{{ proxy_bundle_version }}.cdi -d {{ casfw_home }} -e {{ deploy_env }}
}

function createProxyBundleLink {
    cd {{ casfw_home }}
    ln -sf proxy-bundle-{{ proxy_bundle_version }} proxy-bundle
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
