FROM maven:3.6.3-openjdk-15-slim
WORKDIR /app
COPY ./pom.xml .
COPY ./src/main ./src/main
RUN mvn install
COPY ./src/etc/hh-career-solution ./src/etc/hh-career-solution
ENTRYPOINT ["mvn", "exec:java"]

