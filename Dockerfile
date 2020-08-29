FROM openjdk:14-jdk-alpine
WORKDIR bookapp
EXPOSE 8080
ARG JAR=build/libs/books-0.0.1-SNAPSHOT.jar
ADD ${JAR} books.jar
ENTRYPOINT ['java', '-jar', '/bookapp/books.jar']

