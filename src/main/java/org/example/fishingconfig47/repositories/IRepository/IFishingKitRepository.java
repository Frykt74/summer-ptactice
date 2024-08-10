package org.example.fishingconfig47.repositories.IRepository;

import org.example.fishingconfig47.entities.FishingKit;
import org.example.fishingconfig47.repositories.GenericRepository.DeleteRepository;
import org.example.fishingconfig47.repositories.GenericRepository.ReadRepository;
import org.example.fishingconfig47.repositories.GenericRepository.WriteRepository;

import java.util.List;

public interface IFishingKitRepository extends ReadRepository<FishingKit, Integer>, WriteRepository<FishingKit, Integer>, DeleteRepository<FishingKit, Integer> {
    List<FishingKit> findKitsByRodNameAndReelName(String rodName, String reelName);
}
