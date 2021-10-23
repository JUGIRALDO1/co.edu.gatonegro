FROM openjdk:8-jdk-slim
COPY "./target/app.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]