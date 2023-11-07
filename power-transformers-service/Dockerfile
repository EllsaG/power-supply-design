FROM openjdk:8-jdk-alpine
EXPOSE 8044
COPY build/libs/power-transformers-service-1.0-SNAPSHOT.jar .
RUN apk add --no-cache bash
COPY wait-for.sh /wait-for.sh
RUN chmod +x /wait-for.sh
ENTRYPOINT ["/wait-for.sh", "compensation-device-service:8077", "--timeout=90", "--", "java", "-jar", "power-transformers-service-1.0-SNAPSHOT.jar"]