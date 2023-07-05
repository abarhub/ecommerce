FROM eclipse-temurin:17
COPY target/order-1.0.0-SNAPSHOT.jar order-1.0.0-SNAPSHOT.jar
COPY config/ /config/
ENTRYPOINT ["java", "-DEUREKA_URI=http://discovery:8761/eureka","-Duri=http://configurator:8888","-Dspring.config.import=configserver:http://configurator:8888","-jar","/order-1.0.0-SNAPSHOT.jar", "--server.port=8080", "--spring.config.import=configserver:http://configurator:8888"]