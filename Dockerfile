FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install


 
 
# 2. Just using the build artifact and then removing the build-container
FROM openjdk:11-jdk

VOLUME /tmp
 
# Add Spring Boot app.jar to Container
COPY --from=0 "/home/app/target/GatoNegroSonar-*-SNAPSHOT.jar" app.jar
 
# Fire up our Spring Boot app by default
CMD [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]