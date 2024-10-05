package com.example.telemetry.kafka;

import com.example.telemetry.entity.SensorData;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SensorDataListener {

    @KafkaListener(topics = "heating-system.sensor-data", groupId = "telemetry-group", containerFactory = "kafkaListenerContainerFactory")
    public void listen(SensorData data) {
        System.out.println("Получены данные от устройства: " + data.getDeviceId() + ", температура: " + data.getTemperature());

        // Логика обработки данных от датчиков
    }
}
