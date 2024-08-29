package org.example.fishingconfig47.services.impl;

import org.example.fishingconfig47.dtos.FishingKitDto;
import org.example.fishingconfig47.entities.*;
import org.example.fishingconfig47.exceptions.NotEnoughBudgetException;
import org.example.fishingconfig47.repositories.*;
import org.example.fishingconfig47.services.BudgetKitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetKitServiceImpl implements BudgetKitService {

    private final RodRepository rodRepository;
    private final ReelRepository reelRepository;
    private final LineRepository lineRepository;
    private final LureRepository lureRepository;
    private final RodReelRepository rodReelRepository;
    private final FishingKitRepository fishingKitRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public BudgetKitServiceImpl(RodRepository rodRepository,
                                ReelRepository reelRepository,
                                LineRepository lineRepository,
                                LureRepository lureRepository,
                                RodReelRepository rodReelRepository,
                                FishingKitRepository fishingKitRepository,
                                ModelMapper modelMapper) {

        this.rodRepository = rodRepository;
        this.reelRepository = reelRepository;
        this.lineRepository = lineRepository;
        this.lureRepository = lureRepository;
        this.rodReelRepository = rodReelRepository;
        this.fishingKitRepository = fishingKitRepository;

        this.modelMapper = modelMapper;
    }

    @Override
    public FishingKitDto selectKitByBudget(Integer budget) {
        int rodBudget = (int) (budget * 0.58);
        int reelBudget = (int) (budget * 0.31);
        int lineBudget = (int) (budget * 0.05);
        int lureBudget = (int) (budget * 0.06);

        List<Rod> rods = rodRepository.findTop4ByPriceLessThanEqualOrderByPriceDesc(rodBudget);
        List<Reel> reels = reelRepository.findTop4ByPriceLessThanEqualOrderByPriceDesc(reelBudget);
        List<Line> lines = lineRepository.findTop4ByPriceLessThanEqualOrderByPriceDesc(lineBudget);
        List<Lure> lures = lureRepository.findTop4ByPriceLessThanEqualOrderByPriceDesc(lureBudget);

        if (rods.isEmpty() || reels.isEmpty() || lines.isEmpty() || lures.isEmpty()) {
            throw new NotEnoughBudgetException("Недостаточно средств для создания набора");
        }

        for (Rod rod : rods) {
            for (Reel reel : reels) {
                if (!rodReelRepository.existsRodAndReel(rod, reel)) {
                    continue;
                }

                for (Line line : lines) {
                    if (line.getTestWidth() > reel.getMaxDrag()) {
                        continue;
                    }

                    for (Lure lure : lures) {
                        if (lure.getWeight() < rod.getLureWeightMin() || lure.getWeight() > rod.getLureWeightMax()) {
                            continue;
                        }

                        FishingKit budgetFishingKit = new FishingKit("New kit", rod, reel, line, lure, 0f, 0);

                        FishingKit savedFishingKit = fishingKitRepository.save(budgetFishingKit);
                        return modelMapper.map(savedFishingKit, FishingKitDto.class);
                    }
                }
            }
        }

        throw new NotEnoughBudgetException("Не удалось подобрать подходящий набор для данного бюджета.");
    }
}
