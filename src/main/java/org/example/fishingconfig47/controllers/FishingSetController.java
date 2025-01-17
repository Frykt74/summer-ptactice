package org.example.fishingconfig47.controllers;

import org.example.fishingconfig47.DTO.FishingSetDto;
import org.example.fishingconfig47.entities.*;
import org.example.fishingconfig47.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/fishing-sets")
public class FishingSetController {

    private final FishingSetService fishingSetService;
    private final RodService rodService;
    private final ReelService reelService;
    private final LineService lineService;
    private final LureService lureService;
    private final RodReelService rodReelService;

    @Autowired
    public FishingSetController(FishingSetService fishingSetService,
                                RodService rodService,
                                ReelService reelService,
                                LineService lineService,
                                LureService lureService,
                                RodReelService rodReelService) {
        this.fishingSetService = fishingSetService;
        this.rodService = rodService;
        this.reelService = reelService;
        this.lineService = lineService;
        this.lureService = lureService;
        this.rodReelService = rodReelService;
    }

    @PostMapping("/create")
    public Object createFishingSet(@RequestBody FishingSetDto fishingSetDto) {
        try {
            Rod rod = rodService.getRodById(fishingSetDto.getRodId());
            Reel reel = reelService.getReelById(fishingSetDto.getReelId());
            Line line = lineService.getLineById(fishingSetDto.getLineId());
            Lure lure = lureService.getLureById(fishingSetDto.getLureId());

            return fishingSetService.createFishingSet(fishingSetDto.getName(), rod, reel, line, lure,
                    fishingSetDto.getFishWeight(), fishingSetDto.getFishCount(), rodReelService);


        } catch (Exception e) {
            return ("Failed: " + e.getMessage());
        }
    }
    @PostMapping("/search-budget")
    public FishingSet createFishingSet(@RequestParam String name, @RequestParam Integer rodId, @RequestParam Float fishWeight,
                                       @RequestParam Integer fishCount, @RequestParam double budget) {
        Rod rod = rodService.getRodById(fishingSetDto.getRodId());

        return fishingSetCreationService.createFishingSet(name, rod, fishWeight, fishCount, budget);
    }
}
