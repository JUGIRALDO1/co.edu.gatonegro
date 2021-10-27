FROM openjdk:11
# Add Spring Boot app.jar to Container
COPY  "./home/app/target/GatoNegroSonar-*-SNAPSHOT.jar" "app.jar"
