FROM maven:3.9.7-eclipse-temurin-21-alpine AS build
RUN mkdir /project
COPY . /project
WORKDIR /project
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-alpine
RUN apk add dumb-init
RUN mkdir /app
RUN addgroup --system javauser && adduser -S -s /bin/false -G javauser javauser
COPY --from=build /project/target/springstore-0.0.1-SNAPSHOT.jar /app/springstore.jar
WORKDIR /app
RUN chown -R javauser:javauser /app
USER javauser
CMD "dumb-init" "java" "-jar" "springstore.jar"