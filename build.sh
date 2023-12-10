#!/bin/bash

set -e

cd ProductsService

mvn test

docker build -t productservice .