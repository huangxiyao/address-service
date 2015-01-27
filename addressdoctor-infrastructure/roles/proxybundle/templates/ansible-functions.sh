#!/bin/bash

HOME="/opt/casfw"
userinput="$1"

function installProxyBundleCdi {
    cd {{ casfw_home }}
    sh proxy-bundle-installer-{{ proxy_bundle_release_version }}.cdi -d {{ casfw_home }} -e {{ release_env }}
}

function createProxyBundleLink {
    cd {{ casfw_home }}
    rm -rf proxy-bundle
    ln -sf proxy-bundle-{{ proxy_bundle_release_version }} proxy-bundle
}

$userinput
