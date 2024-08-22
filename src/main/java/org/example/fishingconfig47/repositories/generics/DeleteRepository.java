package org.example.fishingconfig47.repositories.generics;

import org.example.fishingconfig47.entities.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface DeleteRepository<T extends BaseEntity, ID>  {
    void delete(T entity);
    void deleteById(ID id);
}
