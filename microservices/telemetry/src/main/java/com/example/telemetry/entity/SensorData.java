package com.example.telemetry.entity;

public class SensorData {
    private String deviceId;
    private double temperature;

    // Геттеры и сеттеры

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
