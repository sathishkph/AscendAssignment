FROM openjdk:17
EXPOSE 8080
ADD target/user-service-docker.jar user-service-docker.jar
ENTRYPOINT [ "java","-jar","/user-service-docker.jar" ]
