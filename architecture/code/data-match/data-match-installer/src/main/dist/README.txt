
Data Match Installer
====================

In the below sections $CASFW_HOME refer to the directory in which this README.txt
file is located.


Distribution Configuration
--------------------------

The most common configuration parameters have been extracted as tokens and placed
in $CASFW_HOME/etc/casfw.properties. The files which contain the tokens (@@xyz@@)
have ".casfwcfg" extension.
To update the configuration values, change them in $CASFW_HOME/etc/casfw.properties
and run the follwoing command:

  promtp> $CASFW_HOME/bin/config.sh

This will backup your existing files and regenerate based on *.casfwcfg files
and the values in $CASFW_HOME/etc/casfw.properties. This token-based configuration
approach will simplify the automated migration to newer versions of this
distribution.

In addition, if your environment requires additional environment variables you can
add it to $HOME/.casfwrc file. This file is sources by all the commands in this
distribution.


Address Doctor
---------------
Address doctor configuraiton is found in $CASFW_HOME/etc/address-engine.  You can
customize a number of variables related to the address doctor engine.  They are:

* ad_max_memory_usage_mb
* ad_db_path
* ad_cache_size
* ad_unlock_code
* ad_max_address_object_count
* ad_max_thread_count
* ad_max_memory_usage
* ad_preloading_type

Do not modify the values in Config.xml and Parameters.xml file by hand, but rather 
update the values in the casfw.properties file, re-run the config.sh script 
and replace the tokens there.

Application Logging
-------------------
To change logging levels of the application, go to:

$CASFW_HOME/software/data-match-web/WEB-INF/classes/logback.xml.casfwcfg

Modify this file, rerun the $CASFW_HOME/bin/config.sh script.  This will replace
the tokens in that file.  You then need to restart the application server.

