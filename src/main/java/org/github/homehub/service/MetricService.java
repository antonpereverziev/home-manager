package org.github.homehub.service;

import org.github.homehub.models.Device;
import org.github.homehub.models.MetricData;
import org.github.homehub.repositories.DeviceRepository;
import org.github.homehub.repositories.MetricRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class MetricService {

    //@Autowired
    private DeviceRepository deviceRepository;

    //@Autowired
    private MetricRepository metricRepository;

    @Transactional
    public void addTemperatureMetric(String serialNumber, Double temperature) {
        Device device = deviceRepository.findByDeviceId(serialNumber);
        MetricData md = new MetricData();
        md.setDevice(device);
        md.setValue(temperature);
        md.setDateTime(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(device.getTimeZoneId())));
        metricRepository.save(md);
    }

}
