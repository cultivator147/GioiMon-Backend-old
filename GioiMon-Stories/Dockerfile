# Docker Build Stage
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean install
WORKDIR /app/client
RUN mvn clean install

WORKDIR /app/service
RUN mvn clean install

FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/service/target/*.jar app.jar
EXPOSE 8803
ENTRYPOINT ["java", "-jar", "app.jar"]



