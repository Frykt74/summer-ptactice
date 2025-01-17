package org.example.fishingconfig47.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface GenericRepository<T,ID> extends Repository<T,ID> {
    <S extends T> S save(S entity);
    List<T> findAll();
    Optional<T> findById(ID id);
}
