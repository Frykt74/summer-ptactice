package org.example.fishingconfig47.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.fishingconfig47.entities.FishingKit;
import org.example.fishingconfig47.repositories.FishingKitRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FishingKitRepositoryImpl extends CustomCrudRepositoryImpl<FishingKit, Integer> implements FishingKitRepository {

    @PersistenceContext
    private EntityManager entityManager;

    protected FishingKitRepositoryImpl() {
        super(FishingKit.class);
    }

    @Override
    public List<FishingKit> findKitsByRodNameAndReelName(String rodName, String reelName) {
        String jpql = "SELECT fk FROM FishingKit fk WHERE fk.rod.name LIKE :rodName AND fk.reel.name LIKE :reelName";
        return entityManager.createQuery(jpql, FishingKit.class)
                .setParameter("rodName", "%" + rodName + "%")
                .setParameter("reelName", "%" + reelName + "%")
                .getResultList();
    }

    @Override
    public List<FishingKit> findFishingKitsByLureNameAndLureColor(String name, String color) {
        String jpql = "SELECT fs FROM FishingKit fs WHERE fs.lure.name = :name AND fs.lure.color = :color " +
                "ORDER BY fs.fishWeight DESC, fs.fishCount DESC";
        return entityManager.createQuery(jpql, FishingKit.class)
                .setParameter("name", "%" + name +"%")
                .setParameter("color", "%" + color +"%")
                .getResultList();
    }
}
