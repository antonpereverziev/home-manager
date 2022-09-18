package com.baeldung.books.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "device")
@Data
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_device")
    private long id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String serialNumber;

    @OneToMany(mappedBy="device")
    List<MetricData> metrics;

}
