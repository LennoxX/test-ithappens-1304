FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/docker-ithappens.jar docker-ithappens.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","docker-ithappens.jar"]