FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /workspace

COPY pom.xml ./
COPY src ./src
RUN mvn -q -DskipTests clean package

FROM eclipse-temurin:17-jre-jammy
WORKDIR /usrapp/bin

ENV PORT=6000

COPY --from=build /workspace/target/classes ./classes
COPY --from=build /workspace/target/dependency ./dependency

EXPOSE 6000

CMD ["java", "-cp", "./classes:./dependency/*", "org.example.RestServiceApplication"]
