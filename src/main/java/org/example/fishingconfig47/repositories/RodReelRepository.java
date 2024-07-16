package org.example.fishingconfig47.repositories;

import org.example.fishingconfig47.entities.Reel;
import org.example.fishingconfig47.entities.Rod;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RodReelRepository {
    @Query("SELECT CASE WHEN COUNT(rr) > 0 THEN TRUE ELSE FALSE END FROM RodReel rr WHERE rr.rod = :rod AND rr.reel = :reel")
    boolean findByRodAndReel(@Param("rod") Rod rod, @Param("reel") Reel reel);
}
