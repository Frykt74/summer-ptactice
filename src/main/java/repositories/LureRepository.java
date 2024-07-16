package repositories;

import entities.Lure;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;


@Repository
public interface LureRepository {
    @Query("SELECT l FROM Lure l WHERE l.id = :lure_id")
    Lure findLureById(@Param("lure_id") int lure_id);

    @Query("SELECT l FROM Lure l WHERE l.weight BETWEEN :weightMin AND :weightMax")
    List<Lure> findLuresByWeightRange(@Param("weightMin") float weightMin, @Param("weightMax") float weightMax);
}
