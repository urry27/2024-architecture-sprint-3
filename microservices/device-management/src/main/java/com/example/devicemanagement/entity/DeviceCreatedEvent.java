package com.example.devicemanagement.entity;

import java.time.LocalDateTime;

public class DeviceCreatedEvent {
    private String eventId;
    private LocalDateTime occurredAt;
    private String deviceId;
    private String accessData;
}