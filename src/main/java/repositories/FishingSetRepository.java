package repositories;

import entities.FishingSet;
import entities.Lure;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FishingSetRepository {
    void save(FishingSet fishingSet);

    void update(FishingSet fishingSet);

    void delete(Long id);

    @Query("SELECT fs FROM FishingSet fs WHERE fs.id = :fishingSetId")
    Lure findSetById(@Param("fishing_set_id") int fishingSetId);

    @Query("SELECT fs FROM FishingSet fs WHERE fs.rod.name LIKE %:rodBrand% AND fs.reel.name LIKE %:reelBrand%")
    List<FishingSet> findSetsByRodAndReelBrand(@Param("rodBrand") String rodBrand, @Param("reelBrand") String reelBrand);

    @Query("SELECT fs FROM FishingSet fs WHERE fs.lure.name = :type AND fs.lure.color = :color order by fs.fishWeight desc, fs.fishCount desc")
    List<FishingSet> findFishingSetsByLure(@Param("name") String type, @Param("color") String color);

    @Query("SELECT f FROM FishingSet f")
    List<FishingSet> findAll();

}

