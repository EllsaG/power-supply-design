FROM openjdk:8-jdk-alpine
EXPOSE 8011
COPY build/libs/high-volt-cables-service-1.0-SNAPSHOT.jar .
RUN apk add --no-cache bash
COPY wait-for.sh /wait-for.sh
RUN chmod +x /wait-for.sh
ENTRYPOINT ["/wait-for.sh", "full-information-service:8022", "--timeout=90", "--", "java", "-jar", "high-volt-cables-service-1.0-SNAPSHOT.jar"]