FROM gradle:6.9.4-jdk-alpine as builder

COPY ./src src/
COPY ./build.gradle build.gradle

RUN gradle build -x test

FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY build/libs/config-service-1.0-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "power-supply-design-1.0-SNAPSHOT.jar"]