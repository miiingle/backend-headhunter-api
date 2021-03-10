# Headhunter API
![Build Status](https://codebuild.us-east-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoiY1V5YW5HVGRPNW9xVmR3dHlBRURDTlVaUU9wVmxpS1NCWWM5WkN1ZnpzeUtjUXQxWHlOcGl2Yi9UZUZSOWlBdzZIYk5NWUZzcnFwRCtGYmp0NjQ5dEJFPSIsIml2UGFyYW1ldGVyU3BlYyI6ImFWOWQzNkNOd1hwY01RUVkiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=master)

App Server for the Headhunters Looking for Potential Hires

## Debug Build
```
./gradlew clean bootjar
docker build -f DEBUG-Dockerfile -t docker.io/library/headhunter-api:debug .
```