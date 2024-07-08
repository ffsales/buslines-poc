FROM openjdk:17-alpine

LABEL authors="felipe"
WORKDIR /app
COPY ./target/buslines-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar" ,"buslines-0.0.1-SNAPSHOT.jar"]