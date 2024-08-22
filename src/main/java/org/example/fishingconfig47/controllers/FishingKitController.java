package org.example.fishingconfig47.controllers;

import org.example.fishingconfig47.dtos.FishingKitDto;
import org.example.fishingconfig47.entities.FishingKit;
import org.example.fishingconfig47.services.FishingKitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fishing-kits")
public class FishingKitController {
    private final FishingKitService fishingKitService;

    @Autowired
    public FishingKitController(FishingKitService fishingKitService) {
        this.fishingKitService = fishingKitService;
    }

    // Метод для создания нового рыболовного набора
    @PostMapping
    public ResponseEntity<FishingKitDto> createFishingKit(@RequestBody FishingKitDto fishingKitDto) {
        try {
            FishingKitDto createdFishingKit = fishingKitService.createFishingKit(fishingKitDto);
            return new ResponseEntity<>(createdFishingKit, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Метод для анализа эффективности рыболовных наборов
    @GetMapping("/analyze")
    public ResponseEntity<List<FishingKit>> analyzeFishingKits() {
        List<FishingKit> fishingKits = fishingKitService.analyzeFishingKits();
        return new ResponseEntity<>(fishingKits, HttpStatus.OK);
    }
}
