FROM maven:3-openjdk-11-slim AS build
WORKDIR /usr/src/app
COPY . .
RUN mvn install:install-file -Dfile=./lib/orm.jar -DgroupId=org.orm -DartifactId=orm -Dversion=1.0 -Dpackaging=jar
RUN mvn clean install

FROM openjdk:11-jre-slim-buster
WORKDIR /usr/src/app
COPY --from=build /usr/src/app/target/backend-1.1.0.jar ./backend.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "backend.jar"]