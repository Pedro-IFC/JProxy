FROM openjdk:17
WORKDIR /app
COPY target/app-0.0.1-SNAPSHOT.jar jproxy.jar
ENTRYPOINT ["java","-jar","/jproxy.jar"]
EXPOSE 8080
