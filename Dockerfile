FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install
COPY /home/app/target/GatoNegroSonar-0.0.1-SNAPSHOT.jar app.jar

FROM openjdk:11
# Add Spring Boot app.jar to Container
ENTRYPOINT ["java","-jar","app.jar","-Dserver.port=$PORT"]