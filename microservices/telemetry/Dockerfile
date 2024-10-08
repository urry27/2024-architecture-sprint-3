# Используем официальный образ OpenJDK
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем файл с jar-приложением в контейнер
COPY target/telemetry-1.0.0.jar /app/telemetry.jar

# Открываем порт 8081
EXPOSE 8081

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "telemetry.jar"]
