FROM maven:3.6.3-openjdk-15-slim
WORKDIR /app
COPY ./pom.xml .
RUN mvn dependency:copy-dependencies
COPY ./src/main ./src/main
RUN mvn package -P docker
COPY ./src/etc/hh-career-solution ./src/etc/hh-career-solution
ENTRYPOINT ["mvn", "exec:java"]

