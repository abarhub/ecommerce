FROM eclipse-temurin:25.0.1_8-jre-noble
RUN apt-get update && apt-get install -y curl
COPY target/reverseproxy-1.2.0-SNAPSHOT.jar reverseproxy-1.2.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/reverseproxy-1.2.0-SNAPSHOT.jar"]
