FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/*.jar
COPY ./target/participants-0.0.1.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8083