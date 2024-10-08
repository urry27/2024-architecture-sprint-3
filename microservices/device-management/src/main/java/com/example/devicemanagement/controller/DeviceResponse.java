package com.example.devicemanagement.controller;

public class DeviceResponse {
    private String id;
    private String name;
    private String deviceType;
    private String placeId;
    private String accessData;

    public DeviceResponse(String id, String name, String deviceType, String placeId, String accessData) {
        this.id = id;
        this.name = name;
        this.deviceType = deviceType;
        this.placeId = placeId;
        this.accessData = accessData;
    }

    public String getId() {
        return id;
    }
    
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
