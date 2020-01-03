package boardFinder.demo.repository;

import boardFinder.demo.domain.Snowboard;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erik
 */
@Repository
public interface SnowboardRepository extends JpaRepository<Snowboard, Long> {

    @Query("select distinct s from Snowboard s left join fetch s.boardBrand left join fetch s.boardGender  left join fetch s.techDetails left join fetch s.riderLevels")
    List<Snowboard> getAllSnowboards();

    Snowboard findByName(String name);
   
    Snowboard findById(long id);

}
