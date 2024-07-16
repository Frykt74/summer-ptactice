package org.example.fishingconfig47.repositories;

import org.example.fishingconfig47.entities.Lure;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LureRepository {
    @Query("SELECT l FROM Lure l WHERE l.id = :lure_id")
    Lure findLureById(@Param("lure_id") int lure_id);

    @Query("SELECT l FROM Lure l WHERE l.weight BETWEEN :weightMin AND :weightMax")
    List<Lure> findLuresByWeightRange(@Param("weightMin") float weightMin, @Param("weightMax") float weightMax);
}
