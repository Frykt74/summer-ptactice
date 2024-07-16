package servicesImpl;

import entities.FishingSet;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.FishingSetService;

@Service
public class FishingSetServiceImpl implements FishingSetService {

    private final EntityManager entityManager;

    @Autowired
    public FishingSetServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(FishingSet fishingSet) {
        entityManager.persist(fishingSet);
    }

    @Override
    @Transactional
    public void update(FishingSet fishingSet) {
        entityManager.merge(fishingSet);
    }

    @Override
    @Transactional
    public void delete(int id) {
        FishingSet fishingSet = entityManager.find(FishingSet.class, id);
        if (fishingSet != null) {
            entityManager.remove(fishingSet);
        } else {
            throw new NullPointerException();
        }
    }
}
