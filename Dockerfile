FROM amazoncorretto:11 as builder
COPY . /home
WORKDIR /home
RUN ./gradlew bootJar -x test

FROM amazoncorretto:11
WORKDIR /home/app
COPY --from=builder home/build/libs/headhunter-api-latest.jar /home/app/application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/app/application.jar"]