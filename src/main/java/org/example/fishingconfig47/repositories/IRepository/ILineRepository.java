package org.example.fishingconfig47.repositories.IRepository;

import org.example.fishingconfig47.entities.Line;
import org.example.fishingconfig47.repositories.GenericRepository.CreateRepository;
import org.example.fishingconfig47.repositories.GenericRepository.ReadRepository;
import org.example.fishingconfig47.repositories.GenericRepository.UpdateRepository;

import java.util.List;

public interface ILineRepository extends
        CreateRepository<Line, Integer>,
        ReadRepository<Line, Integer>,
        UpdateRepository<Line, Integer> {
    List<Line> findSuitableLinesByTestWidth(float testWidth);
    Line findSuitableLineByMaxDragAndBudget(double maxDrag, double budget);
}
