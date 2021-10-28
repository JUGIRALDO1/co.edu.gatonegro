FROM openjdk:11 AS deploy
# Add Spring Boot app.jar to Container
COPY /app/target/GatoNegroSonar-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar","-Dserver.port=$PORT"]