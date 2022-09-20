package org.github.homehub.repositories;

import org.github.homehub.models.MetricData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(excerptProjection = MetricData.class)
public interface MetricRepository extends CrudRepository<MetricData, Long> {
}
