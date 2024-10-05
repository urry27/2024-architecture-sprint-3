package com.example.devicemanagement.entity;

import java.time.LocalDateTime;

public class DeviceStateChangeRequestedEvent {
    private String eventId;
    private String deviceId;
    private RequestedState requestedState;
}

class RequestedState {  
    private boolean isOn;
}
