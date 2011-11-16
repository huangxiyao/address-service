#!/bin/bash

CASFW_HOME="$(cd "$(dirname "$0")/.." && pwd)"


# Fix permissions
echo "Setting permissions"

# In general we want:
# - user to read+write+browse (i.e. execute for directories, and if execute for files was already there we are fine), 
# - group to read+browse, 
# - others to do nothing
chmod -R u+rwX,g=rX,o= ${CASFW_HOME}

# And now we explicitely set 'execute' permissions for files we know we need
chmod ug+x ${CASFW_HOME}/bin/*.sh
chmod ug+x ${CASFW_HOME}/software/www/auth/*.pl