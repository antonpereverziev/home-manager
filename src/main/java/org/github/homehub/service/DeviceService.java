package org.github.homehub.service;

import org.github.homehub.ewelink.api.model.devices.DeviceItem;
import org.github.homehub.models.AccountInfo;
import org.github.homehub.models.Device;
import org.github.homehub.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public void createAndSaveDevice(AccountInfo savedAccountInfo, DeviceItem deviceItem) {
        Device device = new Device();
        device.setDeviceId(deviceItem.getDeviceid());
        device.setAccount(savedAccountInfo);
        device.setModel(deviceItem.getProductModel());
        device.setName(deviceItem.getName());
        device.setType(deviceItem.getType());
        device.setSerialNumber(deviceItem.getId());
        device.setTimeZoneId("Europe/Kiev");
        deviceRepository.save(device);
    }
}
