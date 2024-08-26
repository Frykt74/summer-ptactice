package org.example.fishingconfig47.repositories;

import org.example.fishingconfig47.entities.Lure;
import org.example.fishingconfig47.repositories.generics.CreateRepository;
import org.example.fishingconfig47.repositories.generics.ReadRepository;
import org.example.fishingconfig47.repositories.generics.UpdateRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface LureRepository extends
        CreateRepository<Lure, Integer>,
        ReadRepository<Lure, Integer>,
        UpdateRepository<Lure, Integer> {
    List<Lure> findLuresByWeight(float weightMin, float weightMax);

    Lure findSuitableLure(double minWeight, double maxWeight, double budget);

    Lure findBudgetLure(double budget);
}
