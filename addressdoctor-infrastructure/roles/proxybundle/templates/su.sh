#!/bin/sh
pbruncasfw={{ pbrun_casfw }}
if [ -x /opt/pb/bin/pbrun ]; then
	if [[ $pbruncasfw = "true" ]]; then
		/opt/pb/bin/pbrun -n su "$@"
	else
		pbrun bash
		su "$@"
	fi
else
    sudo su "$@"
fi
