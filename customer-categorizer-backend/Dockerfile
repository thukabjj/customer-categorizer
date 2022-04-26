FROM gradle:jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon 
RUN ls build/libs

FROM openjdk:17.0.2-slim

EXPOSE 8080

RUN mkdir /app

WORKDIR /app

RUN ls

COPY --from=build /home/gradle/src/sample.db ./
RUN ls
COPY --from=build /home/gradle/src/build/libs/categorizer-0.0.1-SNAPSHOT.jar ./spring-boot-application.jar
RUN ls

ENTRYPOINT ["java","-jar","spring-boot-application.jar"]
