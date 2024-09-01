package org.example.fishingconfig47.repositories;

import org.example.fishingconfig47.entities.FishingKit;
import org.example.fishingconfig47.repositories.generics.CreateRepository;
import org.example.fishingconfig47.repositories.generics.DeleteRepository;
import org.example.fishingconfig47.repositories.generics.ReadRepository;
import org.example.fishingconfig47.repositories.generics.UpdateRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface FishingKitRepository extends
        ReadRepository<FishingKit, Integer>,
        CreateRepository<FishingKit, Integer>,
        UpdateRepository<FishingKit, Integer>,
        DeleteRepository<FishingKit, Integer> {
    List<FishingKit> findKitsByRodNameAndReelName(String rodName, String reelName);

    List<FishingKit> findFishingKitsByLureNameAndLureColor(String name, String color);
}
