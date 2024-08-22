package org.example.fishingconfig47.repositories;

import org.example.fishingconfig47.entities.Reel;
import org.example.fishingconfig47.repositories.generics.CreateRepository;
import org.example.fishingconfig47.repositories.generics.ReadRepository;
import org.example.fishingconfig47.repositories.generics.UpdateRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ReelRepository extends
        CreateRepository<Reel, Integer>,
        ReadRepository<Reel, Integer>,
        UpdateRepository<Reel, Integer> {

    List<Reel> findReelsByGearRatioAndMaxDrag(String gearRatio, float maxDrag);
    Reel findSuitableReel(String rodType, double budget);
}
