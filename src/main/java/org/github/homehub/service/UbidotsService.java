package org.github.homehub.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UbidotsService {

    private static Logger LOG = LoggerFactory.getLogger(UbidotsService.class);

    public void sendData(double temperature) {

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://industrial.api.ubidots.com/api/v1.6/devices/temperature-sensor";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Auth-Token", "BBFF-GGcEOpemMDaPKulSosFqvkSmXQvZq2");
        HttpEntity<TemperatureHolder> request = new HttpEntity<>(new TemperatureHolder(temperature), headers);
        ResponseEntity<String> response = restTemplate
                .exchange(fooResourceUrl, HttpMethod.POST, request, String.class);

        String foo = response.getBody();
        System.out.println("Response " + foo);
    }
}

@Data
@AllArgsConstructor
class TemperatureHolder {
    private double temperature;
}
