package org.example.fishingconfig47.services;

import org.example.fishingconfig47.dtos.FishingKitDto;

import java.util.List;

public interface FishingKitService {
    FishingKitDto createFishingKit(FishingKitDto fishingKitDto);

    List<FishingKitDto> analyzeFishingKits();

    List<FishingKitDto> getAllFishingKits();

    FishingKitDto getFishingKitDtoById(Integer id);

    FishingKitDto updateFishingKit(Integer id, FishingKitDto fishingKitDto);

    void deleteFishingKit(Integer id);
}
