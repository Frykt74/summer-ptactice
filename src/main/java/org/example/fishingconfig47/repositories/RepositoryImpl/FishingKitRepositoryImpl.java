package org.example.fishingconfig47.repositories.RepositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.fishingconfig47.entities.FishingKit;
import org.example.fishingconfig47.repositories.IRepository.IFishingKitRepository;

import java.util.List;

public class FishingKitRepositoryImpl extends CustomCrudRepositoryImpl<FishingKit, Integer> implements IFishingKitRepository {

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
    public List<FishingKit> findFishingKitsByLureName(String name, String color) {
        String jpql = "SELECT fs FROM FishingKit fs WHERE fs.lure.name = :name AND fs.lure.color = :color " +
                "ORDER BY fs.fishWeight DESC, fs.fishCount DESC";
        return entityManager.createQuery(jpql, FishingKit.class)
                .setParameter("name", name)
                .setParameter("color", color)
                .getResultList();
    }

}
