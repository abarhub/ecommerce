FROM eclipse-temurin:21.0.7_6-jre-ubi9-minimal
COPY target/order-1.1.0-SNAPSHOT.jar order-1.1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","/order-1.1.0-SNAPSHOT.jar", "--server.port=8080"]
