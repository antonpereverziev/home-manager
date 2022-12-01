package org.github.homehub.service;

import org.github.homehub.ewelink.api.EweLink;
import org.github.homehub.ewelink.api.model.devices.DeviceItem;
import org.github.homehub.ewelink.api.model.devices.Devices;
import org.github.homehub.models.AccountInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentService {

    private static Logger LOG = LoggerFactory.getLogger(EnrollmentService.class);

    //@Autowired
    //private AccountInfoRepository accountInfoRepository;

    @Autowired
    private DeviceService deviceService;
    
    public void enrollDevicesByAccount(AccountInfo accountInfo) {
        EweLink eweLink = new EweLink(accountInfo.getRegion(), accountInfo.getEmail(), accountInfo.getPassword(), 60);
        try {
            eweLink.login();
            AccountInfo savedAccountInfo = null;//accountInfoRepository.save(accountInfo);
            Devices getDevices = eweLink.getDevices();
            for (DeviceItem deviceItem : getDevices.getDevicelist()) {
                if (deviceItem.getOnline()) {
                    LOG.info("Adding device {} {}", deviceItem.getDeviceid(), deviceItem.getName());
                    deviceService.createAndSaveDevice(savedAccountInfo, deviceItem);
                }
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
}
