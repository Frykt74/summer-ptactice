package org.example.fishingconfig47.repositories.GenericRepository;

import org.example.fishingconfig47.entities.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface DeleteRepository<T extends BaseEntity, ID>  {
    void delete(T entity);
    void deleteById(ID id);
}
