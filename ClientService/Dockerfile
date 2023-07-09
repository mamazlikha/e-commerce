# the first stage of our build will use a maven parent image
FROM maven:3.8.3-openjdk-17 AS MAVEN_BUILD

# copy the pom and src code to the container
COPY ./ ./

# package our application code
RUN mvn clean package -DskipTests

# the second stage of our build
FROM openjdk:17-bullseye

RUN apt-get update
RUN apt-get install wait-for-it

# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD ./target/items-0.0.1-SNAPSHOT.jar ./clientservice.jar

COPY start.sh start.sh
RUN chmod +x start.sh
# set the startup command to execute the jar
ENTRYPOINT ["./start.sh"]