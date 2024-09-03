package org.example.fishingconfig47.services.utils;

import org.example.fishingconfig47.entities.BaseEntity;
import org.example.fishingconfig47.repositories.generics.ReadRepository;

public class EntityFinder {
    public static <T extends BaseEntity, ID> T findByIdOrThrow(ReadRepository<T, ID> repository, ID id, RuntimeException exception) {
        T entity = repository.findById(id);
        if (entity == null) {
            throw exception;
        }
        return entity;
    }
}
