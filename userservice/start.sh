#!/bin/bash

wait-for-it -t 0 $MONGODB_HOST_HOST:$MONGODB_PORT -- java -jar userservice.jar