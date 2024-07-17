package org.example.fishingconfig47.repositories;

import org.example.fishingconfig47.entities.Lure;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LureRepository extends GenericRepository<Lure, Integer> {
    @Query("SELECT l FROM Lure l WHERE l.weight BETWEEN :weightMin AND :weightMax")
    List<Lure> findLuresByWeightRange(@Param("weightMin") float weightMin, @Param("weightMax") float weightMax);

    @Query("SELECT l FROM Lure l WHERE l.price <= :budget AND l.weight BETWEEN :minWeight AND :maxWeight")
    Lure findSuitableLure(@Param("minWeight") double minWeight, @Param("maxWeight") double maxWeight, @Param("budget") double budget);
}
