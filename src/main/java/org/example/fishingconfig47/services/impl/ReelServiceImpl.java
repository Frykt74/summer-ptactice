package org.example.fishingconfig47.services.impl;

import org.example.fishingconfig47.dtos.ReelDto;
import org.example.fishingconfig47.entities.Reel;
import org.example.fishingconfig47.exceptions.ReelNotFoundException;
import org.example.fishingconfig47.repositories.ReelRepository;
import org.example.fishingconfig47.services.ReelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReelServiceImpl implements ReelService {

    private final ReelRepository reelRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ReelServiceImpl(ReelRepository reelRepository, ModelMapper modelMapper) {
        this.reelRepository = reelRepository;
        this.modelMapper = modelMapper;
    }

    public List<ReelDto> getReelsToMatchTheRod(int rodId) {
        List<Reel> findReels = reelRepository.findReelsByRodId(rodId);

        if (findReels.isEmpty()) {
            throw new ReelNotFoundException("Reels for rod not found");
        }

        List<ReelDto> getReels = findReels.stream()
                .map(reel -> modelMapper.map(reel, ReelDto.class))
                .collect(Collectors.toList());

        return getReels;
    }
}
