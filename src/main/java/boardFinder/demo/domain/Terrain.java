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
 *
 * @author Erik
 */
@Entity
public class Terrain implements Serializable {

    @Id
    @SequenceGenerator(name = "bend_s_generator", sequenceName = "bend_s",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bend_s_generator")
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
