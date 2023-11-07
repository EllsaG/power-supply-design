FROM openjdk:8-jdk-alpine
EXPOSE 8033
COPY build/libs/lighting-information-service-1.0-SNAPSHOT.jar .
RUN apk add --no-cache bash
COPY wait-for.sh /wait-for.sh
RUN chmod +x /wait-for.sh
ENTRYPOINT ["/wait-for.sh", "high-volt-cables-service:8011", "--timeout=90", "--", "java", "-jar", "lighting-information-service-1.0-SNAPSHOT.jar"]