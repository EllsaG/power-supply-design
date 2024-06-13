FROM gradle:6.6.1-jdk-alpine as builder

COPY ./src src/
COPY ./build.gradle build.gradle

RUN gradle build -x test

FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY build/libs/config-service-1.0-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "config-service-1.0-SNAPSHOT.jar"]