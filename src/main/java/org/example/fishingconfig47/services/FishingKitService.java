package org.example.fishingconfig47.services;

import org.example.fishingconfig47.dtos.FishingKitDto;

import java.util.List;

public interface FishingKitService {
    FishingKitDto createFishingKit(FishingKitDto fishingKitDto);

    List<FishingKitDto> analyzeFishingKits();

    List<FishingKitDto> getAllFishingKits();

    FishingKitDto getFishingKitDtoById(int id);

    FishingKitDto updateFishingKit(int id, FishingKitDto fishingKitDto);

    void deleteFishingKit(int id);
}
