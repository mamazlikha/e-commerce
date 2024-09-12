#!/bin/bash

set -e

maven_username=$1
maven_token=$2


cd userservice
mvn test
echo $1 $2
docker build --build-arg MAVEN_USERNAME=$1 --build-arg MAVEN_TOKEN=$2 -t userservice .
