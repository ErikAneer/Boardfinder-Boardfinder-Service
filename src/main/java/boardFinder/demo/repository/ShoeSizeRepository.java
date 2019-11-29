package boardFinder.demo.repository;

import boardFinder.demo.domain.ShoeSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erik
 */
@Repository
public interface ShoeSizeRepository extends JpaRepository<ShoeSize, Long> {

    ShoeSize findByEuSize(double shoeSize);

}
