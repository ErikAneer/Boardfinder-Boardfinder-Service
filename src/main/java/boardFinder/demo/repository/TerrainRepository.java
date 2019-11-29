/*

 */
package boardFinder.demo.repository;

import boardFinder.demo.domain.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erik
 */
@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Long> {

    Terrain findById(long id);

}
