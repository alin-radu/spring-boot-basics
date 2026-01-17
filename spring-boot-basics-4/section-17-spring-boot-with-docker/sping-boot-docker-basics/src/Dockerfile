#v1
#FROM openjdk:21-jdk-slim
#COPY target/*.jar app.jar
#EXPOSE 5000
#ENTRYPOINT ["java","-jar","/app.jar"]
#v2
#FROM maven:3.9.6-amazoncorretto-21-al2023 AS build
#WORKDIR /home/app
#COPY . /home/app
#RUN mvn -f /home/app/pom.xml clean package
#
#FROM openjdk:21-jdk-slim
#EXPOSE 5000
#COPY --from=build /home/app/target/*.jar app.jar
#ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]
#v3 | caching
FROM maven:3.9.6-amazoncorretto-21-al2023 AS build
WORKDIR /home/app

COPY ./pom.xml /home/app/pom.xml
COPY .src/main/java/com/dev/spring_boot_docker_basics/Application.java	/home/app/src/main/java/com/dev/spring_boot_docker_basics/Application.java

RUN mvn -f /home/app/pom.xml clean package

COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:21-jdk-slim
EXPOSE 5000
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]