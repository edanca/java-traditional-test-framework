FROM maven:3.6.3-jdk-11-openj9
MAINTAINER Eduardo Cardenas

WORKDIR /tests

COPY pre-pom.xml ./pom.xml

RUN mvn clean install

COPY . .

CMD ["mvn", "clean", "verify"]