# Multi-stage building file

# First stage.
# The code is compiled to an executable.
FROM maven:3.9.7-eclipse-temurin-21 as maven
WORKDIR /app
COPY ./pom.xml .

# Maven in offline mode.
# Download all dependencies and go offline.
RUN mvn dependency:go-offline
COPY ./src ./src

# Package the application, skipping the tests
RUN mvn package -DskipTests=true
WORKDIR /app/target/dependency
RUN jar -xf ../springstore-0.0.1-SNAPSHOT.jar

# Second stage.
# Only necessary parts are copied for running the application.
FROM ibm-semeru-runtimes:open-21-jre-focal
ARG DEPENDENCY=/app/target/dependency
COPY --from=maven ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=maven ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=maven ${DEPENDENCY}/BOOT-INF/classes /app
CMD java -server -Xmx1024m -Xss1024k -XX:MaxMetaspaceSize=135m -XX:CompressedClassSpaceSize=28m -XX:ReservedCodeCacheSize=13m -XX:+IdleTuningGcOnIdle -Xtune:virtualized -cp app:app/lib/* com.mromanode.springstore.SpringstoreApplication