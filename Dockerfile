FROM openjdk:17-jdk-alpine
RUN mkdir /app
WORKDIR /app
COPY /target/*.jar /app/app.jar

COPY src/main/resources/schemas.sql /docker-entrypoint-initdb.d/
ENV POSTGRES_DB=sandbox
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=mysecretpassword

RUN apk update && apk add --no-cache postgresql
EXPOSE 5432

CMD ["java", "-jar", "/app/app.jar"]