#!/bin/bash

set -e

echo "========== Building ProductsService microservice ========\n"
cd ProductsService
echo "========== Running tests ========\n"
mvn test
echo "========== Building ProductsService docker image ! ========\n"
docker build -t productservice .

echo "========== Building CartService microservice ========\n"
cd ../CartService
echo "========== Running tests ========\n"
mvn test
echo "========== Building CartService docker image ! ========\n"
docker build -t cartservice .

echo "========== Building inventoryservice microservice ========\n"
cd ../inventoryservice
echo "========== Running tests ========\n"
mvn test
echo "========== Building inventoryservice docker image ! ========\n"
docker build -t inventoryservice .

echo "========== Building userservice microservice ========\n"
cd ../userservice
echo "========== Running tests ========\n"
export MAVEN_USERNAME=$1
export MAVEN_TOKEN=$2
mvn test -s ./settings.xml
echo "========== Building docker image ! ========\n"
docker build --build-arg MAVEN_USERNAME=$1 --build-arg MAVEN_TOKEN=$2 -t userservice .

echo "========== Build ended ! ========"

