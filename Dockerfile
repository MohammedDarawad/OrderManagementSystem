FROM openjdk:11-jdk-slim
EXPOSE 8080
ARG JAR_FILE=target/oms.jar
ADD ${JAR_FILE} oms.jar
#COPY target/oms.jar oms.jar
#WORKDIR /usr/app
ENTRYPOINT ["java","-jar","/oms.jar"]
