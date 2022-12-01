package org.github.homehub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

//@Entity
//@Table(name = "device")
@Data
public class Device {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="id_device")
    private long id;

    //@Column(nullable = false)
    private String model;

    //@Column(nullable = false)
    private String type;

    //@Column(nullable = false)
    private String name;

    //@Column(name = "serial_number")
    private String serialNumber;

    //@Column(name = "device_id", nullable = false)
    private String deviceId;

    //@Column(name = "time_zone_id")
    private String timeZoneId;

    @JsonIgnore
    //@OneToMany(mappedBy="device")
    private List<MetricData> metrics;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "id_account")
    private AccountInfo account;
}
