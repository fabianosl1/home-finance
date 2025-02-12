FROM gradle:jdk17-alpine AS build

WORKDIR /app

COPY build.gradle .

COPY settings.gradle .

COPY src ./src

RUN gradle build -x test --parallel

FROM amazoncorretto:17-alpine

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]