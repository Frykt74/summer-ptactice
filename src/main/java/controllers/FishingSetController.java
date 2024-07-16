package controllers;

import DTO.FishingSetDto;
import entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.*;

@RestController
@RequestMapping("/api/fishing-sets")
public class FishingSetController {

    private final FishingSetService fishingSetService;
    private final RodService rodService;
    private final ReelService reelService;
    private final LineService lineService;
    private final LureService lureService;

    @Autowired
    public FishingSetController(FishingSetService fishingSetService,
                                RodService rodService,
                                ReelService reelService,
                                LineService lineService,
                                LureService lureService) {
        this.fishingSetService = fishingSetService;
        this.rodService = rodService;
        this.reelService = reelService;
        this.lineService = lineService;
        this.lureService = lureService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createFishingSet(@RequestBody FishingSetDto fishingSetDto) {
        try {
            Rod rod = rodService.getRodById(fishingSetDto.getRodId());
            Reel reel = reelService.getReelById(fishingSetDto.getReelId());
            Line line = lineService.getLineById(fishingSetDto.getLineId());
            Lure lure = lureService.getLureById(fishingSetDto.getLureId());

            FishingSet fishingSet = new FishingSet(
                    fishingSetDto.getName(),
                    rod,
                    reel,
                    line,
                    lure,
                    fishingSetDto.getFishWeight(),
                    fishingSetDto.getFishCount()
            );

            fishingSetService.save(fishingSet);

            return ResponseEntity.status(HttpStatus.CREATED).body("Fishing set created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create fishing set: " + e.getMessage());
        }
    }
}
