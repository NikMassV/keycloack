FROM gradle:8.14.0-jdk24 AS builder
WORKDIR /app
COPY . /app
RUN ./gradlew dependencies --no-daemon
RUN ./gradlew bootJar --no-daemon

FROM amazoncorretto:24
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "app.jar"]
