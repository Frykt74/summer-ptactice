package org.example.fishingconfig47.repositories.generics;

import org.example.fishingconfig47.entities.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ReadRepository<T extends BaseEntity, ID> {
    T findById(ID id);

    List<T> findAll();
}

