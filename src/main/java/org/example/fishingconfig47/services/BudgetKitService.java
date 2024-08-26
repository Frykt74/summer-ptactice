package org.example.fishingconfig47.services;

import org.example.fishingconfig47.entities.FishingKit;

public interface BudgetKitService {
    FishingKit selectKitByBudget(Double budget);
}
