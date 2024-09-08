#!/bin/bash

set -e

maven_username=$1
maven_token=$2

cd ProductsService
mvn test
docker build -t productservice .

cd ../CartService
mvn test
docker build -t cartservice .

cd ../inventoryservice
mvn test
docker build -t inventoryservice .

cd ../ProductsService
mvn test
docker build -t productsservice .

cd ../userservice
mvn test
docker build --build-arg MAVEN_USERNAME=$1 --build-arg MAVEN_TOKEN=$2 -t userservice .
