package org.example.fishingconfig47.repositories.RepositoryImpl;

import org.example.fishingconfig47.entities.Reel;
import org.example.fishingconfig47.repositories.IRepository.IReelRepository;

public class ReelRepositoryImpl extends CustomCrudRepositoryImpl<Reel, Integer> implements IReelRepository {

    protected ReelRepositoryImpl(Class<Reel> entityClass) {
        super(entityClass);
    }
}
