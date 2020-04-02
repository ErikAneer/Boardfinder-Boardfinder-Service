
package boardFinder.demo.repository;

import boardFinder.demo.domain.TechDetail;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for TechDetail entity class. 
 * @author Erik
 */
@Repository
public interface TechDetailRepository extends JpaRepository<TechDetail, Long> {

    /** 
     * Gets a TechDetail by it's id.
     * @param id
     * @return 
     */
    TechDetail findById(long id);
    
    /** 
     * Gets a list of TechDetails by it's type give such as Bend, Flex, Shape etc. 
     * @param techDetailType as String
     * @return list of all TechDetails for the given type. 
     */
    List<TechDetail> findByTechDetailType(String techDetailType);

}
