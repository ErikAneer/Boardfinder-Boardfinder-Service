package boardFinder.demo.repository;

import boardFinder.demo.domain.SnowboardSizeSpecs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for SnowboardSizeSpecs entity class. 
 * @author Erik
 */
@Repository
public interface SnowboardSizeSpecsRepository extends JpaRepository<SnowboardSizeSpecs, Long> {

    /** 
     * Gets a SnowboardSizeSpecs by it's id
     * @param id
     * @return a SnowboardSizeSpecs
     */
    SnowboardSizeSpecs findById(long id);

}
