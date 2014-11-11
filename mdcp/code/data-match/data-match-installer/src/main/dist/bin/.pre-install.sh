#!/bin/sh
CASFW_HOME="$(cd "$(dirname "$0")/.." && pwd)"

#Create Address Doctor Tomcat Instance
TOMCAT_HOME="$(cd $(ls -d ${CASFW_HOME}/software/apache-tomcat-6.* | tail -n1) && pwd)"
TOMCAT_AD_HOME="${CASFW_HOME}/etc/tomcat-ad"
echo "Creating Tomcat instance for ${TOMCAT_HOME}"
echo "in ${TOMCAT_AD_HOME}"

cp -R ${TOMCAT_HOME}/conf ${TOMCAT_AD_HOME}

mkdir -p ${CASFW_HOME}/var/log/tomcat-ad
ln -sf ${CASFW_HOME}/var/log/tomcat-ad ${TOMCAT_AD_HOME}/logs

mkdir -p ${CASFW_HOME}/var/tomcat-ad/temp
mkdir -p ${CASFW_HOME}/var/tomcat-ad/webapps
mkdir -p ${CASFW_HOME}/var/tomcat-ad/work

# ${CASFW_HOME}/etc/tomcat-ad should already exist as we will copy conf files there
ln -sf ${CASFW_HOME}/var/tomcat-ad/temp ${TOMCAT_AD_HOME}/temp
ln -sf ${CASFW_HOME}/var/tomcat-ad/webapps ${TOMCAT_AD_HOME}/webapps
ln -sf ${CASFW_HOME}/var/tomcat-ad/work ${TOMCAT_AD_HOME}/work

# Log directory where the data-match-web application will add its log files
mkdir -p ${CASFW_HOME}/var/log/data-match-web

# Fix permissions
echo "Setting permissions"

# In general we want:
# - user to read+write+browse (i.e. execute for directories, and if execute for files was already there we are fine), 
# - group to read+browse, 
# - others to do nothing
chmod -R u+rwX,g=rX,o=rX ${CASFW_HOME}

# And now we explicitely set 'execute' permissions for files we know we need
chmod ug+x ${CASFW_HOME}/bin/*.sh
for app_dir in $(ls -d ${CASFW_HOME}/software/apache-tomcat-*); do
    chmod ug+x ${app_dir}/bin/*.sh
done

for app_dir in $(ls -d ${CASFW_HOME}/software/oracle-java-* 2>/dev/null); do
    chmod ug+x ${app_dir}/bin/*
    chmod ug+x ${app_dir}/jre/bin/*
done
