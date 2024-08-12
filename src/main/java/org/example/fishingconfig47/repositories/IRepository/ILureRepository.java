package org.example.fishingconfig47.repositories.IRepository;

import org.example.fishingconfig47.entities.Lure;
import org.example.fishingconfig47.repositories.GenericRepository.CreateRepository;
import org.example.fishingconfig47.repositories.GenericRepository.ReadRepository;
import org.example.fishingconfig47.repositories.GenericRepository.UpdateRepository;

public interface ILureRepository extends
        CreateRepository<Lure, Integer>,
        ReadRepository<Lure, Integer>,
        UpdateRepository<Lure, Integer> {
}
