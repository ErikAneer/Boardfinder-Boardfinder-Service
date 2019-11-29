package boardFinder.demo.repository;

import boardFinder.demo.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erik
 */
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
