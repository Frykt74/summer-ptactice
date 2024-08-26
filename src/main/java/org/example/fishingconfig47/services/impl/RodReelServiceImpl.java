package org.example.fishingconfig47.services.impl;

import org.example.fishingconfig47.entities.Reel;
import org.example.fishingconfig47.entities.Rod;
import org.example.fishingconfig47.exceptions.InvalidRodReelCombinationException;
import org.example.fishingconfig47.repositories.RodReelRepository;
import org.example.fishingconfig47.services.RodReelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RodReelServiceImpl implements RodReelService {

    private final RodReelRepository rodReelRepository;

    @Autowired
    public RodReelServiceImpl(RodReelRepository rodReelRepository) {
        this.rodReelRepository = rodReelRepository;
    }

    public boolean existsPairOfRodAndReel(Rod rod, Reel reel) {
        if (!rodReelRepository.existsRodAndReel(rod, reel)) {
            throw new InvalidRodReelCombinationException("Invalid Rod Reel Combination");
        }

        return true;
    }
}
