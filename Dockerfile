FROM corretto:17
ADD target/dynamodbupdater.jar dynamodbupdater.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","dynamodbupdater.jar"]
