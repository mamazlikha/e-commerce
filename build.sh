#!/bin/bash

set -e

echo "========== Building userservice microservice ========"
echo $1 $2
cd userservice
mvn test
docker build --build-arg MAVEN_USERNAME=$1 --build-arg MAVEN_TOKEN=$2 -t userservice .

echo "========== Build eneded ! ========"

