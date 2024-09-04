package org.example.fishingconfig47.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.fishingconfig47.entities.BaseEntity;
import org.example.fishingconfig47.repositories.generics.CreateRepository;
import org.example.fishingconfig47.repositories.generics.DeleteRepository;
import org.example.fishingconfig47.repositories.generics.ReadRepository;
import org.example.fishingconfig47.repositories.generics.UpdateRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public abstract class CustomCrudRepositoryImpl<T extends BaseEntity, ID> implements
        CreateRepository<T, ID>, ReadRepository<T, ID>,
        UpdateRepository<T, ID>, DeleteRepository<T, ID> {

    private final Class<T> entityClass;

    @PersistenceContext
    private EntityManager entityManager;

    protected CustomCrudRepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    @Transactional
    public void delete(T entity) {
        if (entityManager.contains(entity)) {
            entityManager.remove(entity);
        } else {
            entityManager.remove(entityManager.merge(entity));
        }
    }

    @Override
    @Transactional
    public void deleteById(ID id) {
        T entity = entityManager.find(entityClass, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("from " + entityClass.getName(), entityClass)
                .getResultList();
    }

    @Override
    @Transactional
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
