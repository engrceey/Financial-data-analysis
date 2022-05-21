FROM java:11-jdk-alpine

COPY ./target/financial-record 0.0.1-SNAPSHOT /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch demo-docker-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","financial-record 0.0.1-SNAPSHOT"]