package org.example.fishingconfig47.repositories.IRepository;

import org.example.fishingconfig47.entities.Rod;
import org.example.fishingconfig47.repositories.generics.CreateRepository;
import org.example.fishingconfig47.repositories.generics.ReadRepository;
import org.example.fishingconfig47.repositories.generics.UpdateRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface RodRepository extends
        CreateRepository<Rod, Integer>,
        ReadRepository<Rod, Integer>,
        UpdateRepository<Rod, Integer> {
    List<Rod> findRodsByLineTest(float testWeight);
    List<Rod> findRodsInSetsWithFishWeight(float weight);
    List<Rod> findRodsByLure(float lureWeight);
    List<Rod> findRodsByTypeAndFish(String type, float fishWeight);
}
