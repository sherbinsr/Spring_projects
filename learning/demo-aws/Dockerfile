#define base docker image
FROM openjdk:19
LABEL maintainer="Sherbin S"
ADD target/spring-boot-docker.jar springboot-docker-demo.jar
ENTRYPOINT ["java","-jar","springboot-docker-demo.jar"]
