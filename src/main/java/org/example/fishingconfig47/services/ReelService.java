package org.example.fishingconfig47.services;

import org.example.fishingconfig47.entities.Reel;
import org.example.fishingconfig47.repositories.ReelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReelService {

    @Autowired
    private ReelRepository reelRepository;

    public Reel getReelById(Integer id) {
        return reelRepository.findById(id);
    }
}
