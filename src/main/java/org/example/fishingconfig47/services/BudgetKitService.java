package org.example.fishingconfig47.services;

import org.example.fishingconfig47.dtos.FishingKitDto;

public interface BudgetKitService {
    FishingKitDto selectKitByBudget(int budget);
}
