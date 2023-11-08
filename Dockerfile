FROM openjdk:17

RUN apk update --no-cache
RUN adduser -h /home/usrapp -s /bin/bash -D usrapp
USER usrapp

WORKDIR /app

COPY target/aime-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
