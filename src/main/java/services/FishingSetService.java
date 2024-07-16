package services;

import entities.FishingSet;
import jakarta.transaction.Transactional;

public interface FishingSetService {
    void save(FishingSet fishingSet);

    @Transactional
    void update(FishingSet fishingSet);

    @Transactional
    void delete(int id);
}
