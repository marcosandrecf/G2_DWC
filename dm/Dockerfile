FROM maven:3.9.3-eclipse-temurin-17 AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre AS runtime

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ARG PORT
ENV PORT=${PORT:-8080}

EXPOSE ${PORT}

ENTRYPOINT ["java", "-jar", "app.jar"]