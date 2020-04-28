/*

 */
package boardFinder.demo.repository;

import boardFinder.demo.domain.ShoeSize;
import java.text.MessageFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 * Repository implementation class for ShoeSize entity class. 
 * @author Erik
 */
@Repository
public class ShoeSizeRepositoryImpl {

    @PersistenceContext
    private EntityManager em;

    /** 
     * Gets all the showsizes between given min and max shoesizes.
     * @param minSize
     * @param maxSize
     * @return list of the matching shoesizes in the span.
     */
    public List<ShoeSize> findShoeSizeByMinAndMax(double minSize, double maxSize) {
        TypedQuery<ShoeSize> query = em.createQuery(queryBuilder(minSize, maxSize), ShoeSize.class);
        return query.getResultList();
    }

    /** 
     * Creates the sql query to find all shoesizes between the in parameters min and max shoesize. 
     * @param minSize
     * @param maxSize
     * @return query String.
     */
    private String queryBuilder(double minSize, double maxSize) {
        return MessageFormat.format("SELECT s FROM ShoeSize s WHERE s.euSize BETWEEN {0} AND {1}", minSize, maxSize);
    }
}
