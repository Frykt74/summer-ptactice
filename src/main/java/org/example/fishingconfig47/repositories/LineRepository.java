package org.example.fishingconfig47.repositories;

import org.example.fishingconfig47.entities.Line;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineRepository {
    @Query("SELECT l FROM Line l WHERE l.id = :line_id")
    Line findLineById(@Param("line_id") int line_id);

    @Query("SELECT l FROM Line l WHERE l.testWidth <= :testWidth")
    List<Line> findSuitableLines(@Param("testWidth") float testWidth);
}