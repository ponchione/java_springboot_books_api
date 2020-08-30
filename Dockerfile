FROM openjdk:14-jdk-alpine
ARG JAR=build/libs/books-0.0.1-SNAPSHOT.jar
COPY ${JAR} books.jar
ENTRYPOINT ["java", "-jar", "/books.jar"]

