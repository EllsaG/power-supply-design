FROM openjdk:8-jdk-alpine
EXPOSE 8077
COPY build/libs/compensation-device-service-1.0-SNAPSHOT.jar .
RUN apk add --no-cache bash
COPY wait-for.sh /wait-for.sh
RUN chmod +x /wait-for.sh
ENTRYPOINT ["/wait-for.sh", "start-information-service:8066", "--timeout=90", "--", "java", "-jar", "compensation-device-service-1.0-SNAPSHOT.jar"]