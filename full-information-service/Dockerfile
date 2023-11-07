FROM openjdk:8-jdk-alpine
EXPOSE 8022
COPY build/libs/full-information-service-1.0-SNAPSHOT.jar .
RUN apk add --no-cache bash
COPY wait-for.sh /wait-for.sh
RUN chmod +x /wait-for.sh
ENTRYPOINT ["/wait-for.sh", "power-transformers-service:8044", "--timeout=90", "--", "java", "-jar", "full-information-service-1.0-SNAPSHOT.jar"]