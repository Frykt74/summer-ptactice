package org.example.fishingconfig47.repositories.RepositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.fishingconfig47.entities.Lure;
import org.example.fishingconfig47.repositories.IRepository.ILureRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LureRepositoryImpl extends CustomCrudRepositoryImpl<Lure, Integer> implements ILureRepository {

    protected LureRepositoryImpl() {
        super(Lure.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Lure> findLuresByWeight(float weightMin, float weightMax) {
        String jpql = "SELECT l FROM Lure l WHERE l.weight BETWEEN :weightMin AND :weightMax";
        return entityManager.createQuery(jpql, Lure.class)
                .setParameter("weightMin", weightMin)
                .setParameter("weightMax", weightMax)
                .getResultList();
    }

    @Override
    public Lure findSuitableLure(double minWeight, double maxWeight, double budget) {
        String jpql = "SELECT l FROM Lure l WHERE l.price <= :budget AND l.weight BETWEEN :minWeight AND :maxWeight";
        return entityManager.createQuery(jpql, Lure.class)
                .setParameter("budget", budget)
                .setParameter("minWeight", minWeight)
                .setParameter("maxWeight", maxWeight)
                .getSingleResult();
    }
}
