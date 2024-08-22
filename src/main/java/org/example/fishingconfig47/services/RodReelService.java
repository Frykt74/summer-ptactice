package org.example.fishingconfig47.services;

import org.example.fishingconfig47.entities.Reel;
import org.example.fishingconfig47.entities.Rod;
import org.example.fishingconfig47.repositories.RodReelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RodReelService {

    private final RodReelRepository rodReelRepository;

    @Autowired
    public RodReelService(RodReelRepository rodReelRepository) {
        this.rodReelRepository = rodReelRepository;
    }

    public boolean existsPairOfRodAndReel(Rod rod, Reel reel) {
        if (!rodReelRepository.existsRodAndReel(rod, reel)) {
            throw new IllegalArgumentException("The rod and reel doesn't exist");
        }
        return true;
    }
}
