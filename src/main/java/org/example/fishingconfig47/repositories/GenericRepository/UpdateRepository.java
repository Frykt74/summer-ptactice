package org.example.fishingconfig47.repositories.GenericRepository;

import org.example.fishingconfig47.entities.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UpdateRepository<T extends BaseEntity, ID> extends ReadRepository<T, ID> {
    <S extends T> S update(S entity);
}
