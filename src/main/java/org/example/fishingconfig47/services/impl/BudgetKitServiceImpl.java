package org.example.fishingconfig47.services.impl;

import org.example.fishingconfig47.entities.*;
import org.example.fishingconfig47.exceptions.NotEnoughBudgetException;
import org.example.fishingconfig47.exceptions.ServerException;
import org.example.fishingconfig47.repositories.LineRepository;
import org.example.fishingconfig47.repositories.LureRepository;
import org.example.fishingconfig47.repositories.ReelRepository;
import org.example.fishingconfig47.repositories.RodRepository;
import org.example.fishingconfig47.services.BudgetKitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetKitServiceImpl implements BudgetKitService {

    private final RodRepository rodRepository;
    private final ReelRepository reelRepository;
    private final LineRepository lineRepository;
    private final LureRepository lureRepository;

    @Autowired
    public BudgetKitServiceImpl(RodRepository rodRepository,
                                ReelRepository reelRepository,
                                LineRepository lineRepository,
                                LureRepository lureRepository) {

        this.rodRepository = rodRepository;
        this.reelRepository = reelRepository;
        this.lineRepository = lineRepository;
        this.lureRepository = lureRepository;
    }

    @Override
    public FishingKit selectKitByBudget(Double budget) {

    }
}
