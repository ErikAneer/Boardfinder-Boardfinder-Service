/*

 */
package boardFinder.demo.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Entity class that represents a snowboard's riding terrain and how well the snowboard perform in that terrain. 
 * @author Erik
 */
@Entity
public class Terrain implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private RidingTerrain ridingType;
    private int value;

    public Terrain(RidingTerrain ridingType, int value) {
        this.ridingType = ridingType;
        this.value = value;
    }

    public Terrain() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RidingTerrain getRidingType() {
        return ridingType;
    }

    public void setRidingType(RidingTerrain ridingType) {
        this.ridingType = ridingType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
