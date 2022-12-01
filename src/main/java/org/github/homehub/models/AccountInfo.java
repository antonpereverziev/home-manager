package org.github.homehub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

//@Entity
//@Table(name = "account")
@Data
public class AccountInfo {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="id_account")
    private long id;

    @JsonIgnore
    //@OneToMany(mappedBy="account")
    private List<Device> devices;

    //@Column(nullable = false)
    private String email;

    //@Column(nullable = false)
    private String password;

    //@Column(nullable = false)
    private String region;

    //@Column(name="timestamp")
    private ZonedDateTime created;
}
