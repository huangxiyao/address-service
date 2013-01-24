#!/bin/sh
CASFW_HOME="$(cd "$(dirname "$0")/.." && pwd)"

#hai-bo.nie@hp.com
# Create /opt/casfw/current folder if it doesn't exist
CASFW_HOME_CURRENT="/opt/casfw/current"
if [[ ! -d ${CASFW_HOME_CURRENT} ]]; then
	mkdir -p ${CASFW_HOME_CURRENT}
fi

# Get the instance name
AD_INSTANCE_NAME=$(grep ad_instance_name ${CASFW_HOME}/etc/casfw.properties | awk -F "=" '{print $2}')
# Create the symbol link pointing to the current installer
ln -sf ${CASFW_HOME} ${CASFW_HOME_CURRENT}/${AD_INSTANCE_NAME}
# Create init.d folder under ${CASFW_HOME}
mkdir -p ${CASFW_HOME}/init.d
# Create the symbol link pointing to the actual shell script
ln -sf ${CASFW_HOME}/bin/tomcat-ad.sh ${CASFW_HOME}/init.d/tomcat-ad.sh

#Must limit jxmremote.* files to read only for the casfw user
chmod 600 ${CASFW_HOME}/etc/tomcat-ad/conf/jmxremote.password
chmod 600 ${CASFW_HOME}/etc/tomcat-ad/conf/jmxremote.access

#Because tomcat-ad.sh didn't exist before the installer ran, we must explicitly set his permissions to executable
chmod ug+x ${CASFW_HOME}/bin/*.sh

# Print message about URL where tomcat is to run
tomcat_ad_http_port=$(grep tomcat_ad_connector_http_port ${CASFW_HOME}/etc/casfw.properties | awk -F "=" '{print $2}')
echo
echo "Starting Tomcat at http://$(hostname):${tomcat_ad_http_port}"
${CASFW_HOME}/bin/tomcat-ad.sh start

echo
echo "Please check ${CASFW_HOME}/README.txt for details of the components included"
echo "in this installation."
