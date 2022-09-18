package com.baeldung.books.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "metric_data")
@Data
public class MetricData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_metric")
    private long id;

    @Column(nullable = false)
    @JoinColumn(name = "d_value")
    private long value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_device")
    private Device device;

    @Column(name="date_time")
    private Date dateTime;
}
