#!/bin/bash

HOME="/opt/casfw"
userinput="$1"

function cleanupInstance {
      rm -rf {{ casfw_home }}/{{ data_match_instance }}
}

function stopTomcatPS {
     bash {{ casfw_home }}/{{ data_match_instance }}/{{ data_match_release_version }}/bin/tomcat-ad.sh stop -force
}
 
function cleanupCurrent {
      rm -rf {{ casfw_home }}/current/{{ data_match_instance }}
}

function installcdi {
      cd {{ casfw_home }}
      xargs -a {{ release_environment }}-data-match-cdi-args.txt sh data-match-installer-2015.02.cdi      
}

function cleanupcdi {
      rm -rf {{ casfw_home }}/data-match-installer-2015.02.cdi
}

function checkInstance {
       ps -ef | grep {{ data_match_instance }}
}

$userinput
