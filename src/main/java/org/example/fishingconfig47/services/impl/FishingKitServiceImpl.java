package org.example.fishingconfig47.services.impl;

import org.example.fishingconfig47.dtos.FishingKitDto;
import org.example.fishingconfig47.entities.*;
import org.example.fishingconfig47.exceptions.*;
import org.example.fishingconfig47.repositories.*;
import org.example.fishingconfig47.services.FishingKitService;
import org.example.fishingconfig47.services.utils.EntityFinder;
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
        FishingKit fishingKit = convertToKit(fishingKitDto);

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
        FishingKit fishingKit = EntityFinder.findByIdOrThrow(fishingKitRepository, id, new FishingKitNotFoundException(id));
        return convertToDto(fishingKit);
    }

    public FishingKitDto updateFishingKit(int id, FishingKitDto fishingKitDto) {

        FishingKit existingFishingKit = EntityFinder.findByIdOrThrow(fishingKitRepository, id, new FishingKitNotFoundException(id));
        FishingKit updatedFishingKit = convertToKit(fishingKitDto); // for validation
        modelMapper.map(fishingKitDto, existingFishingKit);
        FishingKit savedFishingKit = fishingKitRepository.update(existingFishingKit);
        return convertToDto(savedFishingKit);
    }

    public void deleteFishingKit(int id) {
        fishingKitRepository.delete(
                EntityFinder.findByIdOrThrow(fishingKitRepository, id, new RodNotFoundException(id))
        );
    }

    private FishingKitDto convertToDto(FishingKit fishingKit) {
        return modelMapper.map(fishingKit, FishingKitDto.class);
    }

    private FishingKit convertToKit(FishingKitDto fishingKitDto) {
        FishingKit fishingKit = modelMapper.map(fishingKitDto, FishingKit.class);

        int rodId = fishingKitDto.getRodId();
        int reelId = fishingKitDto.getReelId();
        int lineId = fishingKitDto.getLineId();
        int lureId = fishingKitDto.getLureId();

        Rod rod = EntityFinder.findByIdOrThrow(rodRepository, rodId, new RodNotFoundException(rodId));
        Reel reel = EntityFinder.findByIdOrThrow(reelRepository, reelId, new ReelNotFoundException(reelId));
        Line line = EntityFinder.findByIdOrThrow(lineRepository, lineId, new LineNotFoundException(lineId));
        Lure lure = EntityFinder.findByIdOrThrow(lureRepository, lureId, new LureNotFoundException(lureId));

        if (!rodReelRepository.existsRodAndReel(rod, reel)) {
            throw new InvalidRodReelCombinationException("Катушка не подходит к удилищу");
        }

        fishingKit.setRod(rod);
        fishingKit.setReel(reel, line);
        fishingKit.setLine(line);
        fishingKit.setLure(lure, rod);

        return fishingKit;
    }
}
