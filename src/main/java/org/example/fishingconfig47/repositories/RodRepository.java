package org.example.fishingconfig47.repositories;

import org.example.fishingconfig47.entities.Rod;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RodRepository extends GenericRepository<Rod, Integer> {

    @Query("SELECT r FROM Rod r WHERE :testWeight BETWEEN r.lineWeightMin AND r.lineWeightMax")
    List<Rod> findRodsByLineTest(@Param("testWeight") float testWeight);

    @Query("SELECT rod FROM Rod rod JOIN FishingSet fs ON rod.id = fs.rod.id WHERE fs.fishWeight > :weight ORDER BY fs.fishWeight desc")
    List<Rod> findRodsInSetsWithFishWeight(@Param("weight") float weight);

    @Query("SELECT r FROM Rod r WHERE :lureWeight BETWEEN r.lureWeightMin AND r.lureWeightMax")
    List<Rod> findRodsByLure(@Param("lureWeight") float lureWeight);

    @Query("SELECT r FROM Rod r WHERE r.type = :type AND :fishWeight BETWEEN r.lineWeightMin AND r.lineWeightMax")
    List<Rod> findRodsByTypeAndFish(@Param("type") String type, @Param("fishWeight") float fishWeight);
}
