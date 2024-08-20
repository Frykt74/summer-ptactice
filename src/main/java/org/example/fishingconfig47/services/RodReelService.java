package org.example.fishingconfig47.services;

import org.example.fishingconfig47.entities.Reel;
import org.example.fishingconfig47.entities.Rod;
import org.example.fishingconfig47.repositories.RepositoryImpl.RodReelRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RodReelService {

    @Autowired
    private RodReelRepositoryImpl rodReelRepository;

    public boolean existsPairOfRodAndReel(Rod rod, Reel reel) {
        if (!rodReelRepository.existsRodAndReel(rod, reel)) {
            throw new IllegalArgumentException("The rod and reel doesn't exist");
        }
        return true;
    }
}
