FROM eclipse-temurin:17
COPY target/reverseproxy-1.0.0-SNAPSHOT.jar reverseproxy-1.0.0-SNAPSHOT.jar
#ENTRYPOINT ["tail", "-f", "/dev/null"]
ENTRYPOINT ["java","-DEUREKA_URI=http://discovery:8761/eureka","-jar","/reverseproxy-1.0.0-SNAPSHOT.jar"]
#ENTRYPOINT ["java","-DEUREKA_URI=http://discovery:8761/eureka","-jar","/reverseproxy-1.0.0-SNAPSHOT.jar", "--spring.profiles.active=dockerc"]