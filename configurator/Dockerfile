FROM eclipse-temurin:21.0.7_6-jre-ubi9-minimal
COPY target/configurator-1.1.0-SNAPSHOT.jar configurator-1.1.0-SNAPSHOT.jar
COPY config/ /config/
ENTRYPOINT ["java","-Deureka.client.serviceUrl.defaultZone=http://discovery:8761/eureka","-Dspring.cloud.config.server.native.search-locations=/config","-jar","/configurator-1.1.0-SNAPSHOT.jar"]
