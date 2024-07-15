package repositories;

import entities.Line;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LineRepository {

    @Query("SELECT l FROM Line l WHERE l.testWidth <= :testWidth")
    List<Line> findSuitableLines(@Param("testWidth") float testWidth);
}