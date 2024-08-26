package org.example.fishingconfig47.services.impl;

import org.example.fishingconfig47.entities.Reel;
import org.example.fishingconfig47.exceptions.ReelNotFoundException;
import org.example.fishingconfig47.repositories.ReelRepository;
import org.example.fishingconfig47.services.ReelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReelServiceImpl implements ReelService {

    private final ReelRepository reelRepository;

    @Autowired
    public ReelServiceImpl(ReelRepository reelRepository) {
        this.reelRepository = reelRepository;
    }

    public Reel getReelById(Integer id) {
        Reel findReel = reelRepository.findById(id);
        if (findReel == null) {
            throw new ReelNotFoundException("Reel with id " + id + " not found");
        }

        return findReel;
    }
}
