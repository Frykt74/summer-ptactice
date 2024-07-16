package services;

import entities.FishingSet;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.FishingSetRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FishingSetService {

    private final EntityManager entityManager;

    @Autowired
    private FishingSetRepository fishingSetRepository;

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

    // Анализ эффективности наборов для рыбалки
    public List<FishingSet> analyzeFishingSets() {
        return fishingSetRepository.findAll().stream()
                .sorted(Comparator.comparing(FishingSet::getFishCount).reversed())
                .collect(Collectors.toList());
    }
}
