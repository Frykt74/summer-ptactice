//package org.example.fishingconfig47.controllers;
//
//import org.example.fishingconfig47.dto.FishingKitDto;
//import org.example.fishingconfig47.entities.*;
//import org.example.fishingconfig47.services.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping("/fishing-sets")
//public class FishingKitController {
//
//    private final FishingSetService fishingSetService;
//    private final RodService rodService;
//    private final ReelService reelService;
//    private final LineService lineService;
//    private final LureService lureService;
//    private final RodReelService rodReelService;
//
//    @Autowired
//    public FishingKitController(FishingSetService fishingSetService,
//                                RodService rodService,
//                                ReelService reelService,
//                                LineService lineService,
//                                LureService lureService,
//                                RodReelService rodReelService) {
//        this.fishingSetService = fishingSetService;
//        this.rodService = rodService;
//        this.reelService = reelService;
//        this.lineService = lineService;
//        this.lureService = lureService;
//        this.rodReelService = rodReelService;
//    }
//
//    @PostMapping("/create")
//    public Object createFishingSet(@RequestBody FishingKitDto fishingKitDto) {
//        try {
//            Rod rod = rodService.getRodById(fishingKitDto.getRodId());
//            Reel reel = reelService.getReelById(fishingKitDto.getReelId());
//            Line line = lineService.getLineById(fishingKitDto.getLineId());
//            Lure lure = lureService.getLureById(fishingKitDto.getLureId());
//
//            return fishingSetService.createFishingSet(fishingKitDto.getName(), rod, reel, line, lure,
//                    fishingKitDto.getFishWeight(), fishingKitDto.getFishCount(), rodReelService);
//
//
//        } catch (Exception e) {
//            return ("Failed: " + e.getMessage());
//        }
//    }
//    @PostMapping("/search-budget")
//    public FishingKit createFishingSet(@RequestParam String name, @RequestParam Integer rodId, @RequestParam Float fishWeight,
//                                       @RequestParam Integer fishCount, @RequestParam double budget) {
//        Rod rod = rodService.getRodById(fishingKitDto.getRodId());
//
//        return fishingKitCreationService.createFishingKit(name, rod, fishWeight, fishCount, budget);
//    }
//}
