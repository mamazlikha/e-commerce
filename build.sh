#!/bin/bash

set -e

cd ItemsService

mvn test

docker build -t itemservice .