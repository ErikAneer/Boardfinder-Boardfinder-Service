package boardFinder.demo.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class that represents a riding terrain. 
 * @author Erik
 */
@Entity
public class RidingTerrain implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String ridingTypeName;

    public RidingTerrain(String ridingTypeName) {
        this.ridingTypeName = ridingTypeName;
    }

    public RidingTerrain() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRidingTypeName() {
        return ridingTypeName;
    }

    public void setRidingTypeName(String ridingTypeName) {
        this.ridingTypeName = ridingTypeName;
    }
}
