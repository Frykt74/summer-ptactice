package org.example.fishingconfig47.repositories;

import org.example.fishingconfig47.entities.FishingSet;
import org.example.fishingconfig47.entities.Lure;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FishingSetRepository extends GenericRepository<FishingSet, Integer> {
    @Query("SELECT fs FROM FishingSet fs WHERE fs.rod.name LIKE %:rodBrand% AND fs.reel.name LIKE %:reelBrand%")
    List<FishingSet> findSetsByRodAndReelBrand(@Param("rodBrand") String rodBrand, @Param("reelBrand") String reelBrand);

    @Query("SELECT fs FROM FishingSet fs WHERE fs.lure.name = :name AND fs.lure.color = :color order by fs.fishWeight desc, fs.fishCount desc")
    List<FishingSet> findFishingSetsByLure(@Param("name") String name, @Param("color") String color);
}

