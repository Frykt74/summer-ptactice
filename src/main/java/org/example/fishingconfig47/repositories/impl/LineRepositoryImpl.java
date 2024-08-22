package org.example.fishingconfig47.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.fishingconfig47.entities.Line;
import org.example.fishingconfig47.repositories.IRepository.LineRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LineRepositoryImpl extends CustomCrudRepositoryImpl<Line, Integer> implements LineRepository {

    @PersistenceContext
    private EntityManager entityManager;

    protected LineRepositoryImpl() {
        super(Line.class);
    }

    @Override
    public List<Line> findSuitableLinesByTestWidth(float testWidth) {
        String jpql = "SELECT l FROM Line l WHERE l.testWidth <= :testWidth";
        return entityManager.createQuery(jpql, Line.class)
                .setParameter("testWidth", testWidth)
                .getResultList();
    }

    @Override
    public Line findSuitableLineByMaxDragAndBudget(double maxDrag, double budget) {
        String jpql = "SELECT l FROM Line l WHERE l.price <= :budget AND l.testWidth <= :maxDrag";
        return entityManager.createQuery(jpql, Line.class)
                .setParameter("budget", budget)
                .setParameter("maxDrag", maxDrag)
                .getSingleResult();
    }
}
