package org.example.fishingconfig47.repositories.IRepository;

import org.example.fishingconfig47.entities.Line;
import org.example.fishingconfig47.repositories.GenericRepository.CreateRepository;
import org.example.fishingconfig47.repositories.GenericRepository.ReadRepository;
import org.example.fishingconfig47.repositories.GenericRepository.UpdateRepository;

public interface ILineRepository extends
        CreateRepository<Line, Integer>,
        ReadRepository<Line, Integer>,
        UpdateRepository<Line, Integer> {
}
