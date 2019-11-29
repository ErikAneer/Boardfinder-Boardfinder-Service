/*

 */
package boardFinder.demo.repository;

import boardFinder.demo.domain.SnowboardSizeSpecs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erik
 */
@Repository
public interface SnowboardSizeSpecsRepository extends JpaRepository<SnowboardSizeSpecs, Long> {

    SnowboardSizeSpecs findById(long id);

}
