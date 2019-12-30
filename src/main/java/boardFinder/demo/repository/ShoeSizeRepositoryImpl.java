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
 *
 * @author Erik
 */
@Repository
public class ShoeSizeRepositoryImpl {

    @PersistenceContext
    private EntityManager em;

    public List<ShoeSize> findShoeSizeByMinAndMax(double minSize, double maxSize) {
        TypedQuery<ShoeSize> query = em.createQuery(queryBuilder(minSize, maxSize), ShoeSize.class);
        return query.getResultList();
    }

    private String queryBuilder(double minSize, double maxSize) {
        return MessageFormat.format("SELECT s FROM ShoeSize s WHERE s.euSize BETWEEN {0} AND {1}", minSize, maxSize);
    }

}
