
package boardFinder.demo.repository;

import boardFinder.demo.domain.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Terrain entity class. 
 * @author Erik
 */
@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Long> {

    /** 
     * Gets a riding terrain by it's id. 
     * @param id
     * @return Terrain
     */
    Terrain findById(long id);

}
