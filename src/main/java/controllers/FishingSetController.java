package controllers;

import DTO.FishingSetDto;
import entities.FishingSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.FishingSetService;

@RestController
@RequestMapping("/api/fishing-sets")
public class FishingSetController {

    private final FishingSetService fishingSetService;

    @Autowired
    public FishingSetController(FishingSetService fishingSetService) {
        this.fishingSetService = fishingSetService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createFishingSet(@RequestBody FishingSetDto fishingSetDto) {
        try {
            FishingSet fishingSet = new FishingSet(
                    fishingSetDto.getName(),
                    fishingSetDto.getRod(),
                    fishingSetDto.getReel(),
                    fishingSetDto.getLine(),
                    fishingSetDto.getLure(),
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