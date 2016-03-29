#!/bin/bash

DOCKER_DOMAIN='.docker.local.com'
DNSMASQ_IP=`ip addr show dev docker0 | awk -F'[ /]*' '/inet /{print $3}'`

