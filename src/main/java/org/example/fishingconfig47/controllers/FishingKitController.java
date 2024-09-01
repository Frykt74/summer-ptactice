package org.example.fishingconfig47.controllers;

import org.example.fishingconfig47.dtos.FishingKitDto;
import org.example.fishingconfig47.services.BudgetKitService;
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
    private final BudgetKitService budgetKitService;

    @Autowired
    public FishingKitController(FishingKitService fishingKitService, BudgetKitService budgetKitService) {
        this.fishingKitService = fishingKitService;
        this.budgetKitService = budgetKitService;
    }

    @PostMapping
    public ResponseEntity<FishingKitDto> createFishingKit(@RequestBody FishingKitDto fishingKitDto) {
        FishingKitDto createdFishingKit = fishingKitService.createFishingKit(fishingKitDto);
        return new ResponseEntity<>(createdFishingKit, HttpStatus.CREATED);
    }

    @GetMapping("/analyze")
    public ResponseEntity<List<FishingKitDto>> analyzeFishingKits() {
        List<FishingKitDto> fishingKits = fishingKitService.analyzeFishingKits();
        return new ResponseEntity<>(fishingKits, HttpStatus.OK);
    }

    @PostMapping("/budget")
    public ResponseEntity<FishingKitDto> budgetFishingKits(@RequestBody Integer budget) {
        FishingKitDto budgetFishingKit = budgetKitService.selectKitByBudget(budget);
        return new ResponseEntity<>(budgetFishingKit, HttpStatus.OK);
    }
}
