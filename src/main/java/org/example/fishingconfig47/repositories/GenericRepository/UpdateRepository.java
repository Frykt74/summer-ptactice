package org.example.fishingconfig47.repositories.GenericRepository;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UpdateRepository<T, ID> extends ReadRepository<T, ID> {
    <S extends T> S update(S entity);

}
