package org.example.fishingconfig47.repositories.IRepository;

import org.example.fishingconfig47.entities.FishingKit;
import org.example.fishingconfig47.repositories.GenericRepository.CreateRepository;
import org.example.fishingconfig47.repositories.GenericRepository.ReadRepository;
import org.example.fishingconfig47.repositories.GenericRepository.UpdateRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface IFishingKitRepository extends
        ReadRepository<FishingKit, Integer>,
        CreateRepository<FishingKit, Integer>,
        UpdateRepository<FishingKit, Integer> {
    List<FishingKit> findKitsByRodNameAndReelName(String rodName, String reelName);

    List<FishingKit> findFishingKitsByLureNameAndLureColor(String name, String color);
}
