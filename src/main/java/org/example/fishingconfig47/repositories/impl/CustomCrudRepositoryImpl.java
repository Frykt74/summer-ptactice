package org.example.fishingconfig47.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.fishingconfig47.entities.BaseEntity;
import org.example.fishingconfig47.repositories.GenericRepository.CreateRepository;
import org.example.fishingconfig47.repositories.GenericRepository.DeleteRepository;
import org.example.fishingconfig47.repositories.GenericRepository.ReadRepository;
import org.example.fishingconfig47.repositories.GenericRepository.UpdateRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@NoRepositoryBean
public abstract class CustomCrudRepositoryImpl<T extends BaseEntity, ID> implements CreateRepository<T, ID>, ReadRepository<T, ID>,
        UpdateRepository<T, ID>, DeleteRepository<T, ID> {

    private final Class<T> entityClass;

    @PersistenceContext
    private EntityManager entityManager;

    protected CustomCrudRepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void delete(T entity) {
        if (entityManager.contains(entity)) {
            entityManager.remove(entity);
        } else {
            entityManager.remove(entityManager.merge(entity));
        }
    }

    @Override
    public void deleteById(ID id) {
        T entity = entityManager.find(entityClass, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    @Override
    public T findById(ID id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("from " + entityClass.getName(), entityClass)
                .getResultList();
    }

    @Override
    public <S extends T> S update(S entity) {
        return entityManager.merge(entity);
    }

    @Override
    @Transactional
    public <S extends T> S save(S entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
            return entity;
        } else {
            return entityManager.merge(entity);
        }
    }
}
