package org.github.homehub.repositories;

import org.github.homehub.models.AccountInfo;
import org.github.homehub.models.MetricData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(excerptProjection = MetricData.class)
public interface AccountInfoRepository extends CrudRepository<AccountInfo, Long> {
}
