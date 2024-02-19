FROM amazoncorretto:21.0.2-alpine3.19

LABEL maintainer="lipe.ferreira1609@hotmail.com"

ENV LANG C.UTF-8

CMD java -jar

# Continue with your application deployment
RUN mkdir /opt/app

ADD build/libs/dev.bank*SNAPSHOT.jar /opt/app/app.jar

CMD ["java", "-jar", "/opt/app/app.jar"]