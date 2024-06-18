FROM openjdk:17-jdk-alpine
ADD target/dynamodbupdater.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","dynamodbupdater.jar"]
