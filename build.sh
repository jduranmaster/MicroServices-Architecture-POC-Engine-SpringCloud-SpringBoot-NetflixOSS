#!/bin/bash

# Build project
mvn clean package

# Build docker images
docker build -t eureka eureka/
docker build -t load-balancer load-balancer/
docker build -t app1 app1/
docker build -t app2 app2/
