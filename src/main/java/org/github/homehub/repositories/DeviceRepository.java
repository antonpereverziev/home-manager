package org.github.homehub.repositories;

import org.github.homehub.models.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface DeviceRepository extends PagingAndSortingRepository<Device, Long> {

    Device findByDeviceId(String deviceId);

    List<Device> findByModel(String model);

}