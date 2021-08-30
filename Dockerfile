FROM alpine:3.14.0
RUN apk add --no-cache openjdk11
ADD build/libs/school-app.jar /usr/share/app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/app.jar"]
