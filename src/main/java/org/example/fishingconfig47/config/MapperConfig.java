package org.example.fishingconfig47.config;

import org.example.fishingconfig47.dtos.FishingKitDto;
import org.example.fishingconfig47.entities.BaseEntity;
import org.example.fishingconfig47.entities.FishingKit;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    private final ModelMapper mapper;

    public MapperConfig() {
        ModelMapper modelMapper = new ModelMapper();

        initializeModelMapper(modelMapper);

        mapper = modelMapper;
    }

    @Bean
    public ModelMapper modelMapper() {
        return mapper;
    }

    private void initializeModelMapper(ModelMapper modelMapper) {
        modelMapper.typeMap(FishingKit.class, FishingKitDto.class).addMappings(mapper -> {
            mapper.map(BaseEntity::getId, FishingKitDto::setId);
            mapper.map(fishingKit -> fishingKit.getRod().getId(), FishingKitDto::setRodId);
            mapper.map(fishingKit -> fishingKit.getReel().getId(), FishingKitDto::setReelId);
            mapper.map(fishingKit -> fishingKit.getLine().getId(), FishingKitDto::setLineId);
            mapper.map(fishingKit -> fishingKit.getLure().getId(), FishingKitDto::setLureId);
            mapper.map(FishingKit::getName, FishingKitDto::setName);
            mapper.map(FishingKit::getFishWeight, FishingKitDto::setFishWeight);
            mapper.map(FishingKit::getFishCount, FishingKitDto::setFishCount);
        });
    }
}
