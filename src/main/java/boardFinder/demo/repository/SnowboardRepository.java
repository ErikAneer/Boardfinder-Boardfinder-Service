package boardFinder.demo.repository;

import boardFinder.demo.domain.Snowboard;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Snowboard entity class. 
 * @author Erik
 */
@Repository
public interface SnowboardRepository extends JpaRepository<Snowboard, Long> {

    /** 
     * Gets all snowboards stored in the database. 
     * @return list of Snowboards 
     */
    @Query("select distinct s from Snowboard s left join fetch s.boardBrand left join fetch s.boardGender left join fetch s.warranty left join fetch s.techDetails left join fetch s.riderLevels")
    List<Snowboard> getAllSnowboards();

    /** 
     * Gets a snowboard by it's name.
     * @param name
     * @return Snowboard
     */
    Snowboard findByName(String name);
   
    /** 
     * Gets a snowboard by it's id. 
     * @param id
     * @return Snowboard
     */
    Snowboard findById(long id);

}
