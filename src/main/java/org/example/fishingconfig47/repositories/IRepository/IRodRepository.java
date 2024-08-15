package org.example.fishingconfig47.repositories.IRepository;

import org.example.fishingconfig47.entities.Rod;
import org.example.fishingconfig47.repositories.GenericRepository.CreateRepository;
import org.example.fishingconfig47.repositories.GenericRepository.ReadRepository;
import org.example.fishingconfig47.repositories.GenericRepository.UpdateRepository;

import java.util.List;

public interface IRodRepository extends
        CreateRepository<Rod, Integer>,
        ReadRepository<Rod, Integer>,
        UpdateRepository<Rod, Integer> {
    List<Rod> findRodsByLineTest(float testWeight);
    List<Rod> findRodsInSetsWithFishWeight(float weight);
    List<Rod> findRodsByLure(float lureWeight);
    List<Rod> findRodsByTypeAndFish(String type, float fishWeight);
}
