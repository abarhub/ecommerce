FROM eclipse-temurin:17
COPY target/ui-1.0.0-SNAPSHOT.jar ui-1.0.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-DEUREKA_URI=http://discovery:8761/eureka","-jar","/ui-1.0.0-SNAPSHOT.jar", "--server.port=8083", "--spring.config.import=configserver:http://configurator:8888"]
#ENTRYPOINT ["java", "-jar","/ui-1.0.0-SNAPSHOT.jar", "--spring.profiles.active=dockerc"]