package boardFinder.demo.repository;

import boardFinder.demo.domain.RiderLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for RiderLevel entity class. 
 * @author Erik
 */
@Repository
public interface RiderLevelRepository extends JpaRepository<RiderLevel, Long> {

}
