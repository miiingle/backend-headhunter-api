# Headhunter API
![Build Status](https://codebuild.us-east-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiY1V5YW5HVGRPNW9xVmR3dHlBRURDTlVaUU9wVmxpS1NCWWM5WkN1ZnpzeUtjUXQxWHlOcGl2Yi9UZUZSOWlBdzZIYk5NWUZzcnFwRCtGYmp0NjQ5dEJFPSIsIml2UGFyYW1ldGVyU3BlYyI6ImFWOWQzNkNOd1hwY01RUVkiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=master)

App Server for the Headhunters Looking for Potential Hires

## Spring Initializer
[Initializer: Native](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=2.4.4.BUILD-SNAPSHOT&packaging=jar&jvmVersion=11&groupId=net.miiingle.headhunter&artifactId=headhunter-api&name=headhunter-api&description=Demo%20project%20for%20Spring%20Boot&packageName=net.miiingle.headhunter.api&dependencies=native,oauth2-resource-server,data-r2dbc,data-redis-reactive,data-elasticsearch,postgresql,lombok,webflux)

[Initializer: Java Jar](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=2.4.4.RELEASE&packaging=jar&jvmVersion=11&groupId=net.miiingle.headhunter&artifactId=headhunter-api&name=headhunter-api&description=Demo%20project%20for%20Spring%20Boot&packageName=net.miiingle.headhunter.api&dependencies=oauth2-resource-server,data-r2dbc,data-redis-reactive,data-elasticsearch,postgresql,lombok,webflux,devtools,configuration-processor,actuator,testcontainers)

## Debug Build
```
./gradlew clean bootjar
docker build -f DEBUG-Dockerfile -t docker.io/library/headhunter-api:debug .
```

## KeyCloak Login
```shell
curl \
  -d "client_id=admin-cli" \
  -d "username=admin" \
  -d "password=admin" \   
  -d "grant_type=password" \
  "http://localhost:8081/auth/realms/master/protocol/openid-connect/token"
```