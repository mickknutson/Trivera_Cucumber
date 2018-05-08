#!/bin/bash

echo "Download dependency sources and go offline"

# Download Source jars:
./mvnw dependency:sources -s ../../../Tools/custom-maven-settings.xml

# Go offline
./mvnw dependency:go-offline -s ../../../Tools/custom-maven-settings.xml

echo "done..."
