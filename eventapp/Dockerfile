FROM amazoncorretto:24 as builder
WORKDIR /app

RUN yum update -y && \
    yum install -y findutils && \
    yum clean all

COPY . /app
RUN chmod +x ./gradlew
RUN ./gradlew dependencies --no-daemon
RUN ./gradlew bootJar --no-daemon

FROM amazoncorretto:24
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "app.jar"]
