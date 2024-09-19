#!/bin/bash

set -e

echo "========== Building userservice microservice ========\n"
echo $1 $2
cd userservice
echo "========== Running tests ========\n"
export MAVEN_USERNAME=$1
export MAVEN_TOKEN=$2
mvn test -s ./settings.xml
echo "========== Building docker image ! ========\n"
docker build --build-arg MAVEN_USERNAME=$1 --build-arg MAVEN_TOKEN=$2 -t userservice .

echo "========== Build ended ! ========"

