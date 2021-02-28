FROM amazoncorretto:11 as builder
COPY . /home
WORKDIR /home
RUN ./gradlew --version
RUN ./gradlew build -x test

FROM amazoncorretto:11
WORKDIR /home/app
COPY --from=builder home/build/libs/headhunter-api-latest.jar application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]