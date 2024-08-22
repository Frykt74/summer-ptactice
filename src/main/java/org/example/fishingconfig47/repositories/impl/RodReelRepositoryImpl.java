package org.example.fishingconfig47.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.fishingconfig47.entities.Reel;
import org.example.fishingconfig47.entities.Rod;
import org.example.fishingconfig47.entities.RodReel;
import org.example.fishingconfig47.repositories.RodReelRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RodReelRepositoryImpl extends CustomCrudRepositoryImpl<RodReel, Integer> implements RodReelRepository {
    protected RodReelRepositoryImpl() {
        super(RodReel.class);
    }
//    TODO: add validation condition for record creation

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean existsRodAndReel(Rod rod, Reel reel) {
        String jpql = "SELECT CASE WHEN COUNT(rr) > 0 THEN TRUE ELSE FALSE END FROM RodReel rr WHERE rr.rod = :rod AND rr.reel = :reel";
        return entityManager.createQuery(jpql, Boolean.class)
                .setParameter("rod", rod)
                .setParameter("reel", reel)
                .getSingleResult();
    }
}
