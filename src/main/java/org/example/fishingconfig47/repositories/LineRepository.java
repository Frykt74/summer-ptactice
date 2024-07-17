package org.example.fishingconfig47.repositories;

import org.example.fishingconfig47.entities.Line;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineRepository extends GenericRepository<Line, Integer> {
    @Query("SELECT l FROM Line l WHERE l.testWidth <= :testWidth")
    List<Line> findSuitableLines(@Param("testWidth") float testWidth);

    @Query("SELECT l FROM Line l WHERE l.price <= :budget AND l.testWidth <= :maxDrag")
    Line findSuitableLine(@Param("maxDrag") double maxDrag, @Param("budget") double budget);
}