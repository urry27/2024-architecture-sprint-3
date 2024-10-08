package com.example.devicemanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @PostMapping
    public ResponseEntity<DeviceResponse> createDevice(@RequestBody DeviceRequest deviceRequest) {
        // Логика для создания устройства
        DeviceResponse response = new DeviceResponse(UUID.randomUUID().toString(), deviceRequest.getName(), deviceRequest.getDeviceType(), deviceRequest.getPlaceId(), deviceRequest.getAccessData());
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceResponse> getDevice(@PathVariable String id) {
        // Логика для получения устройства по id
        DeviceResponse response = new DeviceResponse(id, "Устройство 1", "lighting", "9d4969d9-a72b-4346-ac2e-e87dc5872876", "192.168.1.100:8080");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDeviceState(@PathVariable String id, @RequestBody DeviceStateRequest deviceStateRequest) {
        // Логика для обновления состояния устройства
        return ResponseEntity.ok("Состояние устройства обновлено");
    }

    @PostMapping("/{id}/connect")
    public ResponseEntity<?> connectDevice(@PathVariable String id) {
        // Логика для подключения устройства
        return ResponseEntity.ok("Устройство подключено");
    }

    @PostMapping("/{id}/disconnect")
    public ResponseEntity<?> disconnectDevice(@PathVariable String id) {
        // Логика для отключения устройства
        return ResponseEntity.ok("Устройство отключено");
    }

    @PostMapping("/{id}/scenario")
    public ResponseEntity<?> setScenario(@PathVariable String id, @RequestBody ScenarioRequest scenarioRequest) {
        // Логика для задания сценария
        return ResponseEntity.ok("Сценарий задан");
    }
}
