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
    private final RodReelRepository rodReelRepository;

    private final ModelMapper modelMapper;

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
            throw new ReelNotFoundException(fishingKitDto.getReelId());
        }

        if (rod == null) {
            throw new RodNotFoundException(fishingKitDto.getRodId());

        } else if (!rodReelRepository.existsRodAndReel(rod, reel)) {
            throw new InvalidRodReelCombinationException("Катушка не подходит к удилищу");
        }

        Line line = lineRepository.findById(fishingKitDto.getLineId());
        if (line == null) {
            throw new LineNotFoundException(fishingKitDto.getLineId());
        }

        Lure lure = lureRepository.findById(fishingKitDto.getLureId());

        if (lure == null) {
            throw new LureNotFoundException(fishingKitDto.getLureId());
        }

        fishingKit.setRod(rod);
        fishingKit.setReel(reel, line);
        fishingKit.setLine(line);
        fishingKit.setLure(lure, rod);

        FishingKit savedFishingKit = fishingKitRepository.save(fishingKit);
        return convertToDto(savedFishingKit);
    }

    public List<FishingKitDto> analyzeFishingKits() {
        return fishingKitRepository.findAll().stream()
                .sorted(Comparator
                        .comparing(FishingKit::getFishCount, Comparator.reverseOrder())
                        .thenComparing(FishingKit::getFishWeight, Comparator.reverseOrder())
                        .thenComparing(fk -> fk.getFishWeight() / fk.getFishCount(), Comparator.reverseOrder())
                )
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private FishingKitDto convertToDto(FishingKit fishingKit) {
        return modelMapper.map(fishingKit, FishingKitDto.class);
    }
}
