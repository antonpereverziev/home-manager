package com.baeldung.books.repositories;

import com.baeldung.books.models.MetricData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(excerptProjection = MetricData.class)
public interface MetricRepository extends CrudRepository<MetricData, Long> {
}
