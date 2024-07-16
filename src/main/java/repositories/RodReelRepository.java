package repositories;

import entities.Reel;
import entities.Rod;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RodReelRepository {
    @Query("SELECT CASE WHEN COUNT(rr) > 0 THEN TRUE ELSE FALSE END FROM RodReel rr WHERE rr.rod = :rod AND rr.reel = :reel")
    boolean findByRodAndReel(@Param("rod") Rod rod, @Param("reel") Reel reel);
}
