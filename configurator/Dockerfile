FROM eclipse-temurin:25.0.1_8-jre-noble
COPY target/configurator-1.2.0-SNAPSHOT.jar configurator-1.2.0-SNAPSHOT.jar
COPY config/ /config/
ENTRYPOINT ["java","-Deureka.client.serviceUrl.defaultZone=http://discovery:8761/eureka","-Dspring.cloud.config.server.native.search-locations=/config","-jar","/configurator-1.2.0-SNAPSHOT.jar"]
