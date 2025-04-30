FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/ms-peliculas-favoritos-backend-0.0.1-SNAPSHOT.jar ms-peliculas-favoritos-backend.jar
EXPOSE 9094
RUN apt-get update && apt-get install -y curl
ENTRYPOINT ["java", "-jar", "ms-peliculas-favoritos-backend.jar"]