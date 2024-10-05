package com.example.devicemanagement.kafka;

import com.example.devicemanagement.entity.DeviceCreatedEvent;
import com.example.devicemanagement.entity.DeviceStateChangeRequestedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DeviceManagementProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPIC = "device-management.device";

    public void publishDeviceCreated(DeviceCreatedEvent event) {
        kafkaTemplate.send(TOPIC, event);
    }

    public void publishDeviceStateChangeRequested(DeviceStateChangeRequestedEvent event) {
        kafkaTemplate.send(TOPIC, event);
    }
}
