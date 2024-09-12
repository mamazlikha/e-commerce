#!/bin/bash

set -e

echo "========== Building productservice microservice ========"
cd ProductsService
mvn test
docker build -t productservice .

echo "========== Building cartservice microservice ========"
cd ../CartService
mvn test
docker build -t cartservice .

echo "========== Building inventoryservice microservice ========"
cd ../inventoryservice
mvn test
docker build -t inventoryservice .

echo "========== Building userservice microservice ========"
cd ../userservice
mvn test
docker build --build-arg MAVEN_USERNAME=$1 --build-arg MAVEN_TOKEN=$2 -t userservice .

echo $1 $2
echo "========== Build eneded ! ========"

