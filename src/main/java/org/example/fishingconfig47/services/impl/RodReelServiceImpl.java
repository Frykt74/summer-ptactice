package org.example.fishingconfig47.services.impl;

import org.example.fishingconfig47.entities.Reel;
import org.example.fishingconfig47.entities.Rod;
import org.example.fishingconfig47.entities.RodReel;
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

    public RodReel savePairOfRodAndReel(Rod rod, Reel reel) {
        if (!rodReelRepository.existsRodAndReel(rod, reel)) {
            throw new InvalidRodReelCombinationException("Катушка не подходит к удилищу");
        }

        RodReel newCombination = new RodReel(rod, reel);
        return rodReelRepository.save(newCombination);
    }

}
