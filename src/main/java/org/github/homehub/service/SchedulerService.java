package org.github.homehub.service;

import org.github.homehub.ewelink.api.EweLink;
import org.github.homehub.ewelink.api.model.devices.DeviceItem;
import org.github.homehub.models.Device;
import org.github.homehub.repositories.DeviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SchedulerService {

    private static Logger LOG = LoggerFactory.getLogger(SchedulerService.class);

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private MetricService metricService;

    @Autowired
    private UbidotsService ubidotsService;

    private static Map<String, EweLink> CACHE = new HashMap<>();

    @Transactional
    @Scheduled(fixedDelay = 600000)
    public void scheduleFixedDelayTask() {
        List<Device> allDevices = deviceRepository.findByModel("TH16");
        for (Device device : allDevices) {
            EweLink eweLink = CACHE.computeIfAbsent(device.getAccount().getEmail(), x -> new EweLink(device.getAccount().getRegion(),
                    device.getAccount().getEmail(), device.getAccount().getPassword(), 60));
            try {
                eweLink.login();
                DeviceItem thermostat = eweLink.getDevice(device.getDeviceId());
                String temperature = thermostat.getParams().getCurrentTemperature();
                LOG.info(" {} Temperature: {}", device.getDeviceId(), temperature);
                metricService.addTemperatureMetric(device.getDeviceId(), Double.valueOf(temperature));
                ubidotsService.sendData(Double.valueOf(temperature));
            } catch (Exception e) {
                LOG.error(e.getMessage());
            }
        }
    }

    @Scheduled(fixedDelay = 600000)
    public void selfWakeUp() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String fooResourceUrl
                    = "https://home-hub-ap.herokuapp.com/";
            restTemplate.getForEntity(fooResourceUrl, String.class);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
}
