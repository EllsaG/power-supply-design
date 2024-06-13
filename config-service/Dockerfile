FROM gradle:6.9.4-jdk-alpine as builder
COPY ./src src/
COPY ./pom.xml pom.xml

RUN gradle build -x test

FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY --from=builder build/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]