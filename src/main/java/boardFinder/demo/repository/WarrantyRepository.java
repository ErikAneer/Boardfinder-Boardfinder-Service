/*

 */
package boardFinder.demo.repository;

import boardFinder.demo.domain.Warranty;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Warranty entity class. 
 * @author Erik
 */
public interface WarrantyRepository extends JpaRepository<Warranty, Long>{
    
}
