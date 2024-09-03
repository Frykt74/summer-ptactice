package org.example.fishingconfig47.services;

import org.example.fishingconfig47.dtos.ReelDto;

import java.util.List;

public interface ReelService {
    List<ReelDto> getReelsToMatchTheRod(int rodId);
}
