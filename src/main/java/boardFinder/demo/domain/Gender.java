
package boardFinder.demo.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class that represents a rider gender (mens, womens, kids).
 * @author Erik
 */
@Entity
public class Gender implements Serializable{
    
        private final static long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String sex;

    public Gender(String sex) {
        this.sex = sex;
    }

    public Gender() {
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
