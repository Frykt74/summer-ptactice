package org.example.fishingconfig47.repositories.GenericRepository;

import org.example.fishingconfig47.entities.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface UpdateRepository<T extends BaseEntity, ID>  {
    <S extends T> S update(S entity);
}
