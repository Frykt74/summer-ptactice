package repositories;

import entities.FishingSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FishingSetRepository {
    @Query("SELECT fs FROM FishingSet fs WHERE fs.rod.name LIKE %:rodBrand% AND fs.reel.name LIKE %:reelBrand%")
    List<FishingSet> findSetsByRodAndReelBrand(@Param("rodBrand") String rodBrand, @Param("reelBrand") String reelBrand);

    @Query("SELECT fs FROM FishingSet fs WHERE fs.lure.name = :type AND fs.lure.color = :color order by fs.fishWeight desc, fs.fishCount desc")
    List<FishingSet> findFishingSetsByLure(@Param("name") String type, @Param("color") String color);
}

