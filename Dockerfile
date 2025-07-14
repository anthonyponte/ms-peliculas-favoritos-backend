FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/ms-peliculas-favoritos-backend-1.0.0.jar app.jar
EXPOSE 9081
ENTRYPOINT ["java", "-jar", "app.jar"]