FROM openjdk:16
LABEL maintainer="javaguides.net"
ADD target/webapp-0.0.1-SNAPSHOT.jar webapp-0.0.1-docker.jar
ENTRYPOINT ["java", "-jar", "webapp-0.0.1-docker.jar"] 