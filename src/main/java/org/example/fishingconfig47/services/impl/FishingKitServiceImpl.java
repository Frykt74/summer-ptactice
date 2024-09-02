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

        Rod rod = getRodById(fishingKitDto.getRodId());
        Reel reel = getReelById(fishingKitDto.getReelId());

        if (!rodReelRepository.existsRodAndReel(rod, reel)) {
            throw new InvalidRodReelCombinationException("Катушка не подходит к удилищу");
        }

        Line line = getLineById(fishingKitDto.getLineId());
        Lure lure = getLureById(fishingKitDto.getLureId());

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

    public List<FishingKitDto> getAllFishingKits() {
        return fishingKitRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public FishingKitDto getFishingKitDtoById(int id) {
        FishingKit fishingKit = fishingKitRepository.findById(id);
        if (fishingKit == null) {
            throw new FishingKitNotFoundException(id);
        }
        return convertToDto(fishingKit);
    }

    public FishingKitDto updateFishingKit(int id, FishingKitDto fishingKitDto) {
        FishingKit existingFishingKit = getFishingKitById(id);

        Rod newRod = getRodById(fishingKitDto.getRodId());
        Reel newReel = getReelById(fishingKitDto.getReelId());
        Line newLine = getLineById(fishingKitDto.getLineId());
        Lure newLure = getLureById(fishingKitDto.getLureId());

        existingFishingKit.setName(fishingKitDto.getName());
        existingFishingKit.setRod(newRod);
        existingFishingKit.setReel(newReel, newLine);
        existingFishingKit.setLine(newLine);
        existingFishingKit.setLure(newLure, newRod);
        existingFishingKit.setFishCount(fishingKitDto.getFishCount());
        existingFishingKit.setFishWeight(fishingKitDto.getFishWeight());

        FishingKit updatedFishingKit = fishingKitRepository.save(existingFishingKit);
        return convertToDto(updatedFishingKit);
    }

    public void deleteFishingKit(int id) {
        fishingKitRepository.delete(getFishingKitById(id));
    }

    private FishingKitDto convertToDto(FishingKit fishingKit) {
        return modelMapper.map(fishingKit, FishingKitDto.class);
    }

    private FishingKit getFishingKitById(int id) {
        FishingKit fishingKit = fishingKitRepository.findById(id);

        if (fishingKit == null) {
            throw new FishingKitNotFoundException(id);
        }
        return fishingKit;
    }

    private Rod getRodById(int id) {
        Rod rod = rodRepository.findById(id);

        if (rod == null) {
            throw new RodNotFoundException(id);
        }
        return rod;
    }

    private Reel getReelById(int id) {
        Reel reel = reelRepository.findById(id);

        if (reel == null) {
            throw new ReelNotFoundException(id);
        }
        return reel;
    }

    private Line getLineById(int id) {
        Line line = lineRepository.findById(id);

        if (line == null) {
            throw new LineNotFoundException(id);
        }
        return line;
    }

    private Lure getLureById(int id) {
        Lure lure = lureRepository.findById(id);

        if (lure == null) {
            throw new LureNotFoundException(id);
        }
        return lure;
    }
}
