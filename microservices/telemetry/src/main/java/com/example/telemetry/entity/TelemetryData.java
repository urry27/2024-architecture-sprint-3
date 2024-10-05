package com.example.telemetry.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TelemetryData {

    private Long eventId;
    private LocalDateTime occurredAt;
    private String controlModuleId;
    private String deviceId;
    private String data;
}
