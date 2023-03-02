FROM openjdk:17-alpine3.14 as builder

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw install -DskipTests

COPY src ./src

RUN ./mvnw package

FROM openjdk:17-alpine3.14

WORKDIR /app
COPY --from=builder target/mistweaver-0.1-jar-with-dependencies.jar mistweaver-0.1-jar-with-dependencies.jar

CMD java -jar mistweaver-0.1-jar-with-dependencies.jar