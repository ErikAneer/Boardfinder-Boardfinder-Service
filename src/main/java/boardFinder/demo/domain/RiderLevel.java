package boardFinder.demo.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class that represents a rider level. 
 * @author Erik
 */
@Entity
public class RiderLevel implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String riderLevel;
    private String description;

    public RiderLevel() {
    }

    public RiderLevel(String riderLevel, String description) {
        this.riderLevel = riderLevel;
        this.description = description;
    }

    public String getRiderLevel() {
        return riderLevel;
    }

    public void setRiderLevel(String riderLevel) {
        this.riderLevel = riderLevel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
