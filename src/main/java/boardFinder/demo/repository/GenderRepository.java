
package boardFinder.demo.repository;

import boardFinder.demo.domain.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erik
 */
@Repository
public interface GenderRepository extends JpaRepository<Gender, Long>{
    
}
