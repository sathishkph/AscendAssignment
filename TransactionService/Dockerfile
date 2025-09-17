FROM openjdk:17
EXPOSE 9292
ADD target/transaction-service-docker.jar transaction-service-docker.jar
ENTRYPOINT [ "java","-jar","/transaction-service-docker.jar" ]
