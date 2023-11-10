FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

COPY build/libs/backend-project.jar backend-project.jar

ENTRYPOINT ["java", "-jar", "/backend-project.jar"]