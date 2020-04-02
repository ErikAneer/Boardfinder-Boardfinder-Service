
package boardFinder.demo.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Entity class that represents a snowboard brand.
 * @author Erik
 */

@Entity
public class Brand implements Serializable{
    
        private final static long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name="brand_s_generator", sequenceName = "brand_s",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_s_generator")
    private long id;
    private String brandName;

    public Brand() {
    }
  
    public Brand(String brandName) {
        this.brandName = brandName;
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
