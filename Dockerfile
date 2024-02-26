FROM openjdk:21-jdk-slim
WORKDIR /app
COPY application/target/application-1.0-SNAPSHOT.jar /personal_finance_tracker.jar
EXPOSE 8080
CMD ["java", "-jar", "/personal_finance_tracker.jar"]