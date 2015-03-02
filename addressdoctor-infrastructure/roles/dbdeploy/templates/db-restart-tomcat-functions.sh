function stopTomcatInstance {
    cd {{ casfw_home }}
    bash current/{{ data_match_instance }}/bin/tomcat-ad.sh stop -force
}

function startTomcatInstance {
    cd {{ casfw_home }}
    bash current/{{ data_match_instance }}/bin/tomcat-ad.sh start
}

# Make sure tomcat instance finshed start
# TODO: polling check engine log to make sure the db files was loaded
function checkTomcatInstance {
    cd {{ casfw_home }}
#    ps -ef | grep data-match1
    cat current/{{ data_match_instance }}/var/log/data-match-web/ad-engine.log | tail -2 | head -1 | grep "</GetConfig>"
    if [[ $? -eq 0 ]]; then
        echo "Start tomcat instance finished."
    fi
}