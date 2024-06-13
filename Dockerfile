FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY build/libs/power-supply-design-1.0-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "power-supply-design-1.0-SNAPSHOT.jar"]