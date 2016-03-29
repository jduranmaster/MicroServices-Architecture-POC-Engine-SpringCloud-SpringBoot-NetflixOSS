#!/bin/bash

# Arguments:
# - $1 : application name (for container name)
# - $2 : port number 
# - $3 : eureka service uri's (comma separated) 
# - $rest: extra arguments for docker run command

BASEDIR=`dirname $0`

# Load docker script environment variables
. $BASEDIR/env.sh

APPLICATION=$1
DOCKER_IMAGE=$APPLICATION
PORT=$2
CONTAINER_NAME=$APPLICATION'-'$PORT



SERVER_PORT='SERVER_PORT='$PORT
EUREKA_SERVER_SERVICEURL='EUREKA_SERVER_SERVICEURL='$3
EXTRA_PARAMS=${@:4}

# Stop running old container
sudo docker stop $CONTAINER_NAME > /dev/null 2>&1

# Drop old container 
sudo docker rm $CONTAINER_NAME > /dev/null 2>&1

# Run container
sudo docker run -d --dns $DNSMASQ_IP \
	-e $SERVER_PORT \
	-e $EUREKA_SERVER_SERVICEURL \
	--name $CONTAINER_NAME --hostname=$CONTAINER_NAME \
	$EXTRA_PARAMS \
	$DOCKER_IMAGE
if [[ $? -eq 0 ]] # something was wrong running docker container
then
    # update containers dns configuration
	sudo $BASEDIR/update-docker-dns.sh 
	#sudo docker logs --follow --tail 10 $CONTAINER_NAME	
else	
	exit 100
fi
