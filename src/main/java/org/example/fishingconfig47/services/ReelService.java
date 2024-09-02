package org.example.fishingconfig47.services;

import org.example.fishingconfig47.dtos.ReelDto;
import org.example.fishingconfig47.entities.Reel;

import java.util.List;

public interface ReelService {
    Reel getReelById(int id);

    List<ReelDto> getReelsToMatchTheRod(int rodId);
}
