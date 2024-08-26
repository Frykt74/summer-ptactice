package org.example.fishingconfig47.services;

import org.example.fishingconfig47.dtos.FishingKitDto;
import org.example.fishingconfig47.entities.FishingKit;

import java.util.List;

public interface FishingKitService {
    FishingKitDto createFishingKit(FishingKitDto fishingKitDto);
    List<FishingKit> analyzeFishingKits();
}
