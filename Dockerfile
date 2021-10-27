FROM openjdk:11
# Add Spring Boot app.jar to Container
COPY  "./home/app/target/GatoNegroSonar-*-SNAPSHOT.jar" "app.jar"
ENTRYPOINT ["java","-jar","app.jar","-Dserver.port=$PORT"]