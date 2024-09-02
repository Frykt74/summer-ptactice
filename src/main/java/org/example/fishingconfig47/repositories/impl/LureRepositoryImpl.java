package org.example.fishingconfig47.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.fishingconfig47.entities.Lure;
import org.example.fishingconfig47.repositories.LureRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LureRepositoryImpl extends CustomCrudRepositoryImpl<Lure, Integer> implements LureRepository {

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
    public Lure findSuitableLure(float minWeight, float maxWeight, float budget) {
        String jpql = "SELECT l FROM Lure l WHERE l.price <= :budget AND l.weight BETWEEN :minWeight AND :maxWeight";

        return entityManager.createQuery(jpql, Lure.class)
                .setParameter("budget", budget)
                .setParameter("minWeight", minWeight)
                .setParameter("maxWeight", maxWeight)
                .getSingleResult();
    }

    @Override
    public Lure findBudgetLure(float budget) {
        String jpql = "SELECT l FROM Lure l WHERE l.price <= :budget ORDER BY l.price DESC";

        TypedQuery<Lure> query = entityManager.createQuery(jpql, Lure.class);
        query.setParameter("budget", budget);
        query.setMaxResults(1);

        return query.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public List<Lure> findTop4ByPriceLessThanEqualOrderByPriceDesc(float maxPrice) {
        String jpql = "SELECT l FROM Lure l WHERE l.price <= :maxPrice ORDER BY l.price DESC";

        return entityManager.createQuery(jpql, Lure.class)
                .setParameter("maxPrice", maxPrice)
                .setMaxResults(4)
                .getResultList();
    }
}
