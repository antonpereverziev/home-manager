package com.baeldung.books.repositories;

import com.baeldung.books.models.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface DeviceRepository extends PagingAndSortingRepository<Device, Long> {

    @RestResource(path = "nameContains")
    public Page<Device> findByNameContaining(@Param("name") String name, Pageable p);

}