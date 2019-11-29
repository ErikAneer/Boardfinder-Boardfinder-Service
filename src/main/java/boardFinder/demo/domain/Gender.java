
package boardFinder.demo.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Erik
 */
@Entity
public class Gender implements Serializable{
    
        private final static long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name="gender_s_generator", sequenceName = "gender_s",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gender_s_generator")
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
