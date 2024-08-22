package org.example.fishingconfig47.repositories.generics;

import org.example.fishingconfig47.entities.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CreateRepository<T extends BaseEntity, ID> {
    <S extends T> S save(S entity);
}
