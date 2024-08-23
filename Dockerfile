FROM openjdk:18
WORKDIR /app
COPY ./target/AutomatedUnderwriting1-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "AutomatedUnderwriting1-0.0.1-SNAPSHOT.jar"]
