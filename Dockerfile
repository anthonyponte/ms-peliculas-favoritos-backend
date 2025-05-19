FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/ms-peliculas-favoritos-backend-0.0.1-SNAPSHOT.jar ms-peliculas-favoritos-backend.jar
EXPOSE 9094
ENV SPRING_PROFILES_ACTIVE=docker
ENV SERVER_PORT=9094
RUN apt-get update && apt-get install -y curl
ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "-jar", "ms-peliculas-favoritos-backend.jar"]