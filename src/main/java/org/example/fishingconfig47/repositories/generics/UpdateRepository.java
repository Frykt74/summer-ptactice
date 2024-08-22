package org.example.fishingconfig47.repositories.generics;

import org.example.fishingconfig47.entities.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UpdateRepository<T extends BaseEntity, ID>  {
    <S extends T> S update(S entity);
}
