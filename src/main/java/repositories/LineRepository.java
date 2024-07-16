package repositories;

import entities.Line;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LineRepository {
    @Query("SELECT l FROM Line l WHERE l.id = :line_id")
    Line findLineById(@Param("line_id") int line_id);

    @Query("SELECT l FROM Line l WHERE l.testWidth <= :testWidth")
    List<Line> findSuitableLines(@Param("testWidth") float testWidth);
}