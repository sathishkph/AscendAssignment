FROM openjdk:17
EXPOSE 8761
ADD target/service-registery-docker.jar service-registery-docker.jar
ENTRYPOINT [ "java","-jar","/service-registery-docker.jar" ]
