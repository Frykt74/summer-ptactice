package org.example.fishingconfig47.repositories.IRepository;

import org.example.fishingconfig47.entities.Lure;
import org.example.fishingconfig47.repositories.GenericRepository.CreateRepository;
import org.example.fishingconfig47.repositories.GenericRepository.ReadRepository;
import org.example.fishingconfig47.repositories.GenericRepository.UpdateRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface LureRepository extends
        CreateRepository<Lure, Integer>,
        ReadRepository<Lure, Integer>,
        UpdateRepository<Lure, Integer> {
    List<Lure> findLuresByWeight(float weightMin, float weightMax);
    Lure findSuitableLure(double minWeight, double maxWeight, double budget);
}
