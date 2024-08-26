package org.example.fishingconfig47.repositories;

import org.example.fishingconfig47.entities.Reel;
import org.example.fishingconfig47.entities.Rod;
import org.example.fishingconfig47.entities.RodReel;
import org.example.fishingconfig47.repositories.generics.CreateRepository;
import org.example.fishingconfig47.repositories.generics.ReadRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface RodReelRepository extends
        CreateRepository<RodReel, Integer>,
        ReadRepository<RodReel, Integer> {
    boolean existsRodAndReel(Rod rod, Reel reel);
}
