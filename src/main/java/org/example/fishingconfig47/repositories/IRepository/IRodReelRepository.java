package org.example.fishingconfig47.repositories.IRepository;

import org.example.fishingconfig47.entities.Reel;
import org.example.fishingconfig47.entities.Rod;
import org.example.fishingconfig47.entities.RodReel;
import org.example.fishingconfig47.repositories.GenericRepository.CreateRepository;
import org.example.fishingconfig47.repositories.GenericRepository.ReadRepository;

public interface IRodReelRepository extends
        CreateRepository<RodReel, Integer>,
        ReadRepository<RodReel, Integer> {

    boolean existsRodAndReel(Rod rod, Reel reel);
}
