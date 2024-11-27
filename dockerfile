FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} invoicesys-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/invoicesys-0.0.1.jar"]