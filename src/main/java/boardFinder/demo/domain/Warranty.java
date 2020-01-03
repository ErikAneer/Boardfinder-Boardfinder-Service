/*

 */
package boardFinder.demo.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Erik
 */
@Entity
public class Warranty implements Serializable {
    
    @Id
    @SequenceGenerator(name = "bend_s_generator", sequenceName = "bend_s",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bend_s_generator")
    private long id;
    private String header;
    @Length(max = 1000)
    private String description;
    private int years;

    public Warranty(String header, String description, int years) {
        this.header = header;
        this.description = description;
        this.years = years;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
    
    
    
}
