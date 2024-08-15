package org.example.fishingconfig47.repositories.RepositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.fishingconfig47.entities.Reel;
import org.example.fishingconfig47.repositories.IRepository.IReelRepository;

import java.util.List;

public class ReelRepositoryImpl extends CustomCrudRepositoryImpl<Reel, Integer> implements IReelRepository {

    protected ReelRepositoryImpl(Class<Reel> entityClass) {
        super(entityClass);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Reel> findReelsByGearRatioAndMaxDrag(String gearRatio, float maxDrag) {
        String jpql = "SELECT r FROM Reel r WHERE r.gearRatio = :gearRatio AND r.maxDrag = :maxDrag";
        return entityManager.createQuery(jpql, Reel.class)
                .setParameter("gearRatio", gearRatio)
                .setParameter("maxDrag", maxDrag)
                .getResultList();
    }

    @Override
    public Reel findSuitableReel(String rodType, double budget) {
        String jpql = "SELECT r FROM Reel r WHERE r.price <= :budget AND r.type = :rodType";
        return entityManager.createQuery(jpql, Reel.class)
                .setParameter("budget", budget)
                .setParameter("rodType", rodType)
                .getSingleResult();
    }
}
