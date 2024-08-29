package org.example.fishingconfig47.controllers;

import org.example.fishingconfig47.dtos.ReelDto;
import org.example.fishingconfig47.services.ReelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reels")
public class ReelController {
    private final ReelService reelService;

    @Autowired
    public ReelController(ReelService reelService) {
        this.reelService = reelService;
    }

    @GetMapping("/rod/{rodId}")
    public ResponseEntity<List<ReelDto>> getReelsToMatchTheRod(@PathVariable Long rodId) {
        List<ReelDto> reels = reelService.getReelsToMatchTheRod(rodId);
        return ResponseEntity.ok(reels);
    }
}
