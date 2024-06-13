FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY build/libs/config-service-1.0-SNAPSHOT.jar /app/config-service-1.0-snapshot.jar
ENTRYPOINT ["java", "-jar", "config-service-1.0-SNAPSHOT.jar"]