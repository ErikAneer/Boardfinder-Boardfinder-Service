/*

 */
package boardFinder.demo.repository;

import boardFinder.demo.domain.Snowboard;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erik
 */
@Repository
public class CustomSnowboardRepository {
    
    private static final String QUERY =
            "SELECT distinct s from Snowboard s left join fetch s.boardBrand left join fetch s.boardGender  left join fetch s.boardFlex left join fetch s.boardBend left join fetch s.core left join fetch s.boardShape left join fetch s.riderLevels"
            + " WHERE s.boardGender.sex = :gender AND s.boardflex.flex = :flex"; 
    
   @PersistenceContext
   private EntityManager em;
    
    public List<Snowboard> getAllSnowboardsByQueryParamsMap(Map<String, Object> map) {
    
            return em.createQuery(QUERY)
                    .setParameter("gender", map.get("gender"))
                    .setParameter("flex", map.get("flex"))
                    .getResultList();
        
    }
            
}
