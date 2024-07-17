package org.example.fishingconfig47.services;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.example.fishingconfig47.entities.*;
import org.example.fishingconfig47.repositories.FishingSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FishingSetService {

    private final EntityManager entityManager;

    @Autowired
    private FishingSetRepository fishingSetRepository;
    @Autowired
    private RodReelService rodReelService;

    @Autowired
    public FishingSetService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(FishingSet fishingSet) {
        entityManager.persist(fishingSet);
    }

    @Transactional
    public void update(FishingSet fishingSet) {
        entityManager.merge(fishingSet);
    }

    @Transactional
    public void delete(int id) {
        FishingSet fishingSet = entityManager.find(FishingSet.class, id);
        if (fishingSet != null) {
            entityManager.remove(fishingSet);
        } else {
            throw new NullPointerException();
        }
    }

    @Transactional
    public FishingSet createFishingSet(String name, Rod rod, Reel reel, Line line, Lure lure, Float fishWeight, Integer fishCount, RodReelService rodReelService) {
        try {
            validateSet(rod, reel, line, lure, fishWeight, fishCount);
            FishingSet fishingSet = new FishingSet(name, rod, reel, line, lure, fishWeight, fishCount, rodReelService);
            return fishingSetRepository.save(fishingSet);
        } catch (Exception e) {
            throw new IllegalArgumentException("Ошибка при создании набора для рыбалки: " + e.getMessage());
        }
    }

    private void validateSet(Rod rod, Reel reel, Line line, Lure lure, Float fishWeight, Integer fishCount) {
        if (rod == null || reel == null || line == null || lure == null || fishWeight == null || fishCount == null) {
            throw new NullPointerException("Один из параметров равен null");
        }
        if (fishWeight < 0 || fishCount < 0) {
            throw new IllegalArgumentException("Вес рыбы и количество рыбы должны быть положительными");
        }
        if (!rodReelService.existsRodAndReel(rod, reel)) {
            throw new IllegalArgumentException("Эта комбинация удилища и катушки недопустима");
        }
        if (line.getTestWidth() > reel.getMaxDrag()) {
            throw new IllegalArgumentException("Нагрузка лески не должна превышать мощность фрикциона");
        }
        if (lure.getWeight() < rod.getLureWeightMin() || lure.getWeight() > rod.getLureWeightMax()) {
            throw new IllegalArgumentException("Масса приманки должна быть в диапазоне теста удилища");
        }
    }

    // Анализ эффективности наборов для рыбалки
    public List<FishingSet> analyzeFishingSets() {
        return fishingSetRepository.findAll().stream()
                .sorted(Comparator.comparing(FishingSet::getFishCount).reversed())
                .collect(Collectors.toList());
    }
}
