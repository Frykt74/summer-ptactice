package org.example.fishingconfig47.repositories;

import org.example.fishingconfig47.entities.Reel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReelRepository extends GenericRepository<Reel, Integer> {
    @Query("SELECT r FROM Reel r WHERE r.gearRatio = :gearRatio AND r.maxDrag = :maxDrag")
    List<Reel> findReelsByGearRatioAndMaxDrag(@Param("gearRatio") String gearRatio, @Param("maxDrag") float maxDrag);

    @Query("SELECT r FROM Reel r WHERE r.price <= :budget AND r.type = :rodType")
    Reel findSuitableReel(@Param("rodType") String rodType, @Param("budget") double budget);
}
