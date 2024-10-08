package com.example.devicemanagement.controller;

public class DeviceRequest {
    private String name;
    private String deviceType;
    private String placeId;
    private String accessData;

    // Геттеры
    public String getName() {
        return name;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getPlaceId() {
        return placeId;
    }

    public String getAccessData() {
        return accessData;
    }
}
