package org.example.fishingconfig47.repositories.IRepository;

import org.example.fishingconfig47.entities.Reel;
import org.example.fishingconfig47.repositories.GenericRepository.CreateRepository;
import org.example.fishingconfig47.repositories.GenericRepository.ReadRepository;
import org.example.fishingconfig47.repositories.GenericRepository.UpdateRepository;

public interface IReelRepository extends
        CreateRepository<Reel, Integer>,
        ReadRepository<Reel, Integer>,
        UpdateRepository<Reel, Integer> {
}
