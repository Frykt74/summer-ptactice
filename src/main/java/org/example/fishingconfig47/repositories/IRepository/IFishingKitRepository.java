package org.example.fishingconfig47.repositories.IRepository;

import org.example.fishingconfig47.entities.FishingKit;
import org.example.fishingconfig47.repositories.GenericRepository.DeleteRepository;
import org.example.fishingconfig47.repositories.GenericRepository.ReadRepository;
import org.example.fishingconfig47.repositories.GenericRepository.CreateRepository;
import org.example.fishingconfig47.repositories.GenericRepository.UpdateRepository;

import java.util.List;
import java.util.function.UnaryOperator;

public interface IFishingKitRepository extends ReadRepository<FishingKit, Integer>, CreateRepository<FishingKit, Integer>,
        DeleteRepository<FishingKit, Integer>, UpdateRepository<FishingKit, Integer> {
    List<FishingKit> findKitsByRodNameAndReelName(String rodName, String reelName);
}
