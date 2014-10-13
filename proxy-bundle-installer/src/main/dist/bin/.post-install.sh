#!/bin/bash
CASFW_HOME="$(cd "$(dirname "$0")/.." && pwd)"

source ${CASFW_HOME}/bin/.casfwrc

#Because the scripts didn't exist before the installer ran, we must explicitly set his permissions to executable
chmod ug+x ${CASFW_HOME}/bin/*.sh

mkdir -p ${CASFW_HOME}/var/log/

environment="$(get_property_value "${CASFW_HOME}/etc/casfw.properties" "environment")"
ln -sf ${CASFW_HOME}/etc/${environment}-httpd-conf ${CASFW_HOME}/etc/conf.d

ln -sf /opt/webhost/WHA-General-Inst/apache/logs ${CASFW_HOME}/var/log/apache
ln -sf /opt/webhost/WHA-General-Inst/apache/logs/siteminder ${CASFW_HOME}/var/log/siteminder

chmod -R au+rx ${CASFW_HOME}

echo
echo "Please check ${CASFW_HOME}/README.txt for details of the components included"
echo "in this installation."
