package org.example.fishingconfig47.services;

import org.example.fishingconfig47.entities.Reel;
import org.example.fishingconfig47.entities.Rod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.fishingconfig47.repositories.RodReelRepository;

@Service
public class RodReelService {

    @Autowired
    private RodReelRepository rodReelRepository;

    public boolean existsRodAndReel(Rod rod, Reel reel) {
        return rodReelRepository.findByRodAndReel(rod, reel);
    }
}
