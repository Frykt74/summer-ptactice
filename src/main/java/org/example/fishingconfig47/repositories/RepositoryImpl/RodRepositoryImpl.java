package org.example.fishingconfig47.repositories.RepositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.fishingconfig47.entities.Rod;
import org.example.fishingconfig47.repositories.IRepository.RodRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RodRepositoryImpl extends CustomCrudRepositoryImpl<Rod, Integer> implements RodRepository {

    @PersistenceContext
    private EntityManager entityManager;

    protected RodRepositoryImpl() {
        super(Rod.class);
    }

    @Override
    public List<Rod> findRodsByLineTest(float testWeight) {
        String jpql = "SELECT r FROM Rod r WHERE :testWeight BETWEEN r.lineWeightMin AND r.lineWeightMax";
        return entityManager.createQuery(jpql, Rod.class)
                .setParameter("testWeight", testWeight)
                .getResultList();
    }

    @Override
    public List<Rod> findRodsInSetsWithFishWeight(float weight) {
        String jpql = "SELECT rod FROM Rod rod JOIN FishingKit fs ON rod.id = fs.rod.id WHERE fs.fishWeight > :weight ORDER BY fs.fishWeight desc";
        return entityManager.createQuery(jpql, Rod.class)
                .setParameter("weight", weight)
                .getResultList();
    }

    @Override
    public List<Rod> findRodsByLure(float lureWeight) {
        String jpql = "SELECT r FROM Rod r WHERE :lureWeight BETWEEN r.lureWeightMin AND r.lureWeightMax";
        return entityManager.createQuery(jpql, Rod.class)
                .setParameter("lureWeight", lureWeight)
                .getResultList();
    }

    @Override
    public List<Rod> findRodsByTypeAndFish(String type, float fishWeight) {
        String jpql = "SELECT r FROM Rod r WHERE r.type = :type AND :fishWeight BETWEEN r.lineWeightMin AND r.lineWeightMax";
        return entityManager.createQuery(jpql, Rod.class)
                .setParameter("type", type)
                .setParameter("fishWeight", fishWeight)
                .getResultList();
    }
}
