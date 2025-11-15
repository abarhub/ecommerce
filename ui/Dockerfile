FROM eclipse-temurin:25.0.1_8-jre-noble
RUN apt-get update && apt-get install -y curl
COPY target/ui-1.2.0-SNAPSHOT.jar ui-1.2.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","/ui-1.2.0-SNAPSHOT.jar", "--server.port=8083"]
