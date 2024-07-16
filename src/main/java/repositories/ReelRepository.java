package repositories;

import entities.Reel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReelRepository {
    @Query("SELECT r FROM Reel r WHERE r.id = :reel_id")
    Reel findReelById(@Param("reel_id") int reel_id);

    @Query("SELECT r FROM Reel r WHERE r.gearRatio = :gearRatio AND r.maxDrag = :maxDrag")
    List<Reel> findReelsByGearRatioAndMaxDrag(@Param("gearRatio") String gearRatio, @Param("maxDrag") float maxDrag);
}
