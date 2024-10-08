package com.example.telemetry.kafka;

import com.example.telemetry.entity.TelemetryData;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TelemetryProducer {

    private final KafkaTemplate<String, TelemetryData> kafkaTemplate;

    public TelemetryProducer(KafkaTemplate<String, TelemetryData> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTelemetryData(TelemetryData telemetryData) {
        kafkaTemplate.send("telemetry.data", telemetryData);
    }
}
