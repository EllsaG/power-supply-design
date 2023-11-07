FROM openjdk:8-jdk-alpine
EXPOSE 8066
COPY build/libs/start-information-service-1.0-SNAPSHOT.jar .
RUN apk add --no-cache bash
COPY wait-for.sh /wait-for.sh
RUN chmod +x /wait-for.sh
ENTRYPOINT ["/wait-for.sh", "protective-equipment-service:8055", "--timeout=90", "--", "java", "-jar", "start-information-service-1.0-SNAPSHOT.jar"]