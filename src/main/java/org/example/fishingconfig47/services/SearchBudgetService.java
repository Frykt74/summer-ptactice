package org.example.fishingconfig47.services;

import jakarta.transaction.Transactional;
import org.example.fishingconfig47.entities.*;
import org.example.fishingconfig47.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchBudgetService {

    private final RodReelService rodReelService;
    private final FishingSetRepository fishingSetRepository;
    private final ReelRepository reelRepository;
    private final LineRepository lineRepository;
    private final LureRepository lureRepository;

    @Autowired
    public SearchBudgetService(RodReelService rodReelService, FishingSetRepository fishingSetRepository, ReelRepository reelRepository, LineRepository lineRepository, LureRepository lureRepository) {
        this.rodReelService = rodReelService;
        this.fishingSetRepository = fishingSetRepository;
        this.reelRepository = reelRepository;
        this.lineRepository = lineRepository;
        this.lureRepository = lureRepository;
    }

    @Transactional
    public FishingSet searchFishingSetByBudget(String name, Rod rod, Float fishWeight, Integer fishCount, double budget) {
        try {
            Reel reel = findReelWithinBudget(rod, budget);
            double remainingBudget = budget - reel.getPrice();

            Line line = findLineWithinBudget(reel, remainingBudget);
            remainingBudget -= line.getPrice();

            Lure lure = findLureWithinBudget(rod, remainingBudget);

            if (lure == null) {
                throw new IllegalArgumentException("Не удалось найти подходящие компоненты для заданного бюджета");
            }

            FishingSet fishingSet = new FishingSet (name, rod, reel, line, lure, fishWeight, fishCount, rodReelService);

            return fishingSetRepository.save(fishingSet);
        } catch (Exception e) {
            throw new IllegalArgumentException("Ошибка при создании набора для рыбалки: " + e.getMessage(), e);
        }
    }

    private Reel findReelWithinBudget(Rod rod, double budget) {
        return reelRepository.findSuitableReel(rod.getType(), budget);
    }

    private Line findLineWithinBudget(Reel reel, double budget) {
        return lineRepository.findSuitableLine(reel.getMaxDrag(), budget);
    }

    private Lure findLureWithinBudget(Rod rod, double budget) {
        return lureRepository.findSuitableLure(rod.getLureWeightMin(), rod.getLureWeightMax(), budget);
    }
}
