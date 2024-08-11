package org.example.fishingconfig47.repositories.GenericRepository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface CreateRepository<T, ID> extends Repository<T, ID> {
    <S extends T> S save(S entity);
}
