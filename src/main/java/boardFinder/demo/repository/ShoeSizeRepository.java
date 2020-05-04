package boardFinder.demo.repository;

import boardFinder.demo.domain.ShoeSize;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for ShoeSize entity class. 
 * @author Erik
 */
@Repository
public interface ShoeSizeRepository extends JpaRepository<ShoeSize, Long> {

    /** 
     * Gets a shoeSize by it's EU size.
     * @param shoeSize
     * @return 
     */
    ShoeSize findByEuSize(double shoeSize);
    
}
