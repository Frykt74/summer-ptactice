package org.example.fishingconfig47.services.impl;

import org.example.fishingconfig47.dtos.FishingKitDto;
import org.example.fishingconfig47.entities.*;
import org.example.fishingconfig47.exceptions.*;
import org.example.fishingconfig47.repositories.*;
import org.example.fishingconfig47.services.FishingKitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FishingKitServiceImpl implements FishingKitService {

    private final FishingKitRepository fishingKitRepository;
    private final RodRepository rodRepository;
    private final ReelRepository reelRepository;
    private final LineRepository lineRepository;
    private final LureRepository lureRepository;
    private final ModelMapper modelMapper;
    private final RodReelRepository rodReelRepository;

    @Autowired
    public FishingKitServiceImpl(
            FishingKitRepository fishingKitRepository,
            RodRepository rodRepository,
            ReelRepository reelRepository,
            LineRepository lineRepository,
            LureRepository lureRepository,
            RodReelRepository rodReelRepository,

            ModelMapper modelMapper) {
        this.fishingKitRepository = fishingKitRepository;
        this.rodRepository = rodRepository;
        this.reelRepository = reelRepository;
        this.lineRepository = lineRepository;
        this.lureRepository = lureRepository;
        this.rodReelRepository = rodReelRepository;

        this.modelMapper = modelMapper;
    }

    public FishingKitDto createFishingKit(FishingKitDto fishingKitDto) {
        FishingKit fishingKit = modelMapper.map(fishingKitDto, FishingKit.class);

        Rod rod = rodRepository.findById(fishingKitDto.getRodId());
        Reel reel = reelRepository.findById(fishingKitDto.getReelId());

        if (reel == null) {
            throw new ReelNotFoundException("Reel with id " + fishingKitDto.getReelId() + " not found");
        }

        if (rod == null) {
            throw new RodNotFoundException("Rod with id " + fishingKitDto.getRodId() + " not found");

        } else if (!rodReelRepository.existsRodAndReel(rod, reel)) {
            throw new InvalidRodReelCombinationException("Invalid Rod Reel Combination");
        }

        Line line = lineRepository.findById(fishingKitDto.getLineId());
        if (line == null) {
            throw new LineNotFoundException("Line with id " + fishingKitDto.getLineId() + " not found");
        }

        Lure lure = lureRepository.findById(fishingKitDto.getLureId());

        if (lure == null) {
            throw new LureNotFoundException("Lure with id " + fishingKitDto.getLureId() + " not found");
        }

        fishingKit.setRod(rod);
        fishingKit.setReel(reel, line);
        fishingKit.setLine(line);
        fishingKit.setLure(lure, rod);

        FishingKit savedFishingKit = fishingKitRepository.save(fishingKit);
        return convertToDto(savedFishingKit);
    }

    public List<FishingKit> analyzeFishingKits() {
        return fishingKitRepository.findAll().stream()
                .sorted(Comparator
                        .comparing(FishingKit::getFishCount, Comparator.reverseOrder())
                        .thenComparing(FishingKit::getFishWeight, Comparator.reverseOrder())
                        .thenComparing(fk -> fk.getFishWeight() / fk.getFishCount(), Comparator.reverseOrder())
                ).collect(Collectors.toList());
    }

    private FishingKitDto convertToDto(FishingKit fishingKit) {
        return modelMapper.map(fishingKit, FishingKitDto.class);
    }
}
