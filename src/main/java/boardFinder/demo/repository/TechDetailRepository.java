/*

 */
package boardFinder.demo.repository;

import boardFinder.demo.domain.TechDetail;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erik
 */
@Repository
public interface TechDetailRepository extends JpaRepository<TechDetail, Long> {

    TechDetail findById(long id);
    
    List<TechDetail> findByTechDetailType(String techDetailType);

}
