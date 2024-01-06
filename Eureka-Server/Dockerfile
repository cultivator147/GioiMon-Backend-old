# Docker Build Stage
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean install

FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENV PORT 8761
EXPOSE $PORT
ENTRYPOINT ["java", "-jar", "app.jar"]


# Docker Build Stage
#FROM maven:3.8.3-openjdk-17 AS build
#
#
## Build Stage
#WORKDIR /opt/app
#
#COPY ./ /opt/app
#RUN mvn clean install -DskipTests
#
## Docker Build Stage
#FROM openjdk:17-alpine
#WORKDIR /opt/app
#COPY --from=build /opt/app/target/*.jar app.jar
#
#ENV PORT 8761
#EXPOSE $PORT
#
#ENTRYPOINT ["java","-jar","-Xmx1024M","-Dserver.port=${PORT}","app.jar","--spring.profiles.active=pro"]

