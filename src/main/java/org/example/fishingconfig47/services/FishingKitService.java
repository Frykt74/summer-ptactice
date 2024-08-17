package org.example.fishingconfig47.services;

import org.example.fishingconfig47.dto.FishingKitDto;
import org.example.fishingconfig47.entities.*;
import org.example.fishingconfig47.repositories.RepositoryImpl.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FishingKitService {

    private final FishingKitRepositoryImpl fishingKitRepository;
    private final RodRepositoryImpl rodRepository;
    private final ReelRepositoryImpl reelRepository;
    private final LineRepositoryImpl lineRepository;
    private final LureRepositoryImpl lureRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FishingKitService(
            FishingKitRepositoryImpl fishingKitRepository,
            RodRepositoryImpl rodRepository,
            ReelRepositoryImpl reelRepository,
            LineRepositoryImpl lineRepository,
            LureRepositoryImpl lureRepository,
            ModelMapper modelMapper) {
        this.fishingKitRepository = fishingKitRepository;
        this.rodRepository = rodRepository;
        this.reelRepository = reelRepository;
        this.lineRepository = lineRepository;
        this.lureRepository = lureRepository;
        this.modelMapper = modelMapper;
    }

    public FishingKitDto createFishingKit(FishingKitDto fishingKitDto) {
        FishingKit fishingKit = convertToEntity(fishingKitDto);
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


    private FishingKit convertToEntity(FishingKitDto fishingKitDto) {
        FishingKit fishingKit = modelMapper.map(fishingKitDto, FishingKit.class);

        Rod rod = rodRepository.findById(fishingKitDto.getRodId());
        if (rod == null) {
            throw new IllegalArgumentException("Invalid Rod ID");
        }
        Reel reel = reelRepository.findById(fishingKitDto.getReelId());
        if (reel == null) {
            throw new IllegalArgumentException("Invalid Reel ID");
        }
        Line line = lineRepository.findById(fishingKitDto.getLineId());
        if (line == null) {
            throw new IllegalArgumentException("Invalid Line ID");
        }
        Lure lure = lureRepository.findById(fishingKitDto.getLureId());
        if (lure == null) {
            throw new IllegalArgumentException("Invalid Lure ID");
        }

        fishingKit.setRod(rod, reel);
        fishingKit.setReel(reel, line);
        fishingKit.setLine(line);
        fishingKit.setLure(lure, rod);

        return fishingKit;
    }

    private FishingKitDto convertToDto(FishingKit fishingKit) {
        return modelMapper.map(fishingKit, FishingKitDto.class);
    }
}
