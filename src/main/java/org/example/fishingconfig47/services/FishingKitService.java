package org.example.fishingconfig47.services;

import org.example.fishingconfig47.dtos.FishingKitDto;
import org.example.fishingconfig47.entities.*;
import org.example.fishingconfig47.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FishingKitService {

    private final FishingKitRepository fishingKitRepository;
    private final RodRepository rodRepository;
    private final ReelRepository reelRepository;
    private final LineRepository lineRepository;
    private final LureRepository lureRepository;
    private final ModelMapper modelMapper;
    private final RodReelService rodReelService;

    @Autowired
    public FishingKitService(
            FishingKitRepository fishingKitRepository,
            RodRepository rodRepository,
            ReelRepository reelRepository,
            LineRepository lineRepository,
            LureRepository lureRepository,
            RodReelService rodReelService,
            ModelMapper modelMapper) {
        this.fishingKitRepository = fishingKitRepository;
        this.rodRepository = rodRepository;
        this.reelRepository = reelRepository;
        this.lineRepository = lineRepository;
        this.lureRepository = lureRepository;
        this.rodReelService = rodReelService;
        this.modelMapper = modelMapper;

//        configureModelMapper();
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
        Reel reel = reelRepository.findById(fishingKitDto.getReelId());
        if (reel == null) {
            throw new IllegalArgumentException("Invalid Reel ID");
        }
        if (rod == null) {
            throw new IllegalArgumentException("Rod cannot be null");
        } else if (!rodReelService.existsPairOfRodAndReel(rod, reel)) {
            throw new IllegalArgumentException("Pair of Rod and Reel cannot be found");
        }
        Line line = lineRepository.findById(fishingKitDto.getLineId());
        if (line == null) {
            throw new IllegalArgumentException("Invalid Line ID");
        }
        Lure lure = lureRepository.findById(fishingKitDto.getLureId());
        if (lure == null) {
            throw new IllegalArgumentException("Invalid Lure ID");
        }


        fishingKit.setRod(rod);
        fishingKit.setReel(reel, line);
        fishingKit.setLine(line);
        fishingKit.setLure(lure, rod);

        return fishingKit;
    }

    private FishingKitDto convertToDto(FishingKit fishingKit) {
        return modelMapper.map(fishingKit, FishingKitDto.class);
    }

//    private void configureModelMapper() {
//        modelMapper.createTypeMap(FishingKitDto.class, FishingKit.class)
//                .addMappings(new PropertyMap<FishingKitDto, FishingKit>() {
//                    @Override
//                    protected void configure() {
//                        map().setName(source.getName());
//                        map().setFishWeight(source.getFishWeight());
//                        map().setFishCount(source.getFishCount());
//
//                        using(ctx -> rodRepository.findById(source.getRodId()))
//                                .map(source, destination.getRod());
//                        using(ctx -> reelRepository.findById(source.getReelId()))
//                                .map(source, destination.getReel());
//                        using(ctx -> lineRepository.findById(source.getLineId()))
//                                .map(source, destination.getLine());
//                        using(ctx -> lureRepository.findById(source.getLureId()))
//                                .map(source, destination.getLure());
//                    }
//                });
//    }
}
