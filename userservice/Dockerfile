# the first stage of our build will use a maven parent image
FROM maven:3.8.3-openjdk-17 AS MAVEN_BUILD

# Accept environment variables for Maven credentials
ARG MAVEN_USERNAME
ARG MAVEN_TOKEN

# copy the pom and src code to the container
COPY ./ ./

COPY ./settings.xml /root/.m2/settings.xml

# Replace the placeholders with the actual secrets
RUN sed -i 's/${MAVEN_USERNAME}/'${MAVEN_USERNAME}'/g' /root/.m2/settings.xml && \
    sed -i 's/${MAVEN_TOKEN}/'${MAVEN_TOKEN}'/g' /root/.m2/settings.xml

RUN cat /root/.m2/settings.xml

# package our application code
RUN mvn clean package -DskipTests

# the second stage of our build
FROM eclipse-temurin:17-jammy

RUN apt-get -y update
RUN apt-get -y install wait-for-it

# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD ./target/userservice-0.0.1-SNAPSHOT.jar ./userservice.jar

COPY start.sh start.sh
RUN chmod +x start.sh

# set the startup command to execute the jar
CMD ["sh","start.sh"]