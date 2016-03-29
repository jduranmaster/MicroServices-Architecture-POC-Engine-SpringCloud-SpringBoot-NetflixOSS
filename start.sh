#!/bin/bash


EUREKA_SERVICE_URIS='http://eureka-8700.docker.local.com:8700/eureka/,http://eureka-8701.docker.local.com:8701/eureka/,http://eureka-8702.docker.local.com:8702/eureka/'

# Starts eureka nodes
docker/launch-eureka-container.sh eureka replica-node 8700 $EUREKA_SERVICE_URIS
docker/launch-eureka-container.sh eureka replica-node 8701 $EUREKA_SERVICE_URIS
docker/launch-eureka-container.sh eureka replica-node 8702 $EUREKA_SERVICE_URIS


# Starts zuul load balancer
docker/launch-container.sh load-balancer 8000 $EUREKA_SERVICE_URIS

# Starts some microservices instances
docker/launch-container.sh app1 8800 $EUREKA_SERVICE_URIS
docker/launch-container.sh app1 8801 $EUREKA_SERVICE_URIS
docker/launch-container.sh app1 8802 $EUREKA_SERVICE_URIS

docker/launch-container.sh app2 8900 $EUREKA_SERVICE_URIS
docker/launch-container.sh app2 8901 $EUREKA_SERVICE_URIS
