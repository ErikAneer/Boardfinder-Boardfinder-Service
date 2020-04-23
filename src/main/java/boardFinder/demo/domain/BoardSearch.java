
package boardFinder.demo.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Entity class that represents a snowboard search.
 * @author Erik
 */

@Entity
public class BoardSearch implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    
    private String gender;
    private int weight;
    private double shoeSize;
    private String riderLevel;
    private String terrain;
    private String shape;
    private String flex;
    private String bend;

    public BoardSearch() {
    }

    public BoardSearch(String gender, int weight, double shoeSize, String riderLevel, String terrain, String shape, String flex, String bend) {
        this.gender = gender;
        this.weight = weight;
        this.shoeSize = shoeSize;
        this.riderLevel = riderLevel;
        this.terrain = terrain;
        this.shape = shape;
        this.flex = flex;
        this.bend = bend;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(double shoeSize) {
        this.shoeSize = shoeSize;
    }

    public String getRiderLevel() {
        return riderLevel;
    }

    public void setRiderLevel(String riderLevel) {
        this.riderLevel = riderLevel;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getFlex() {
        return flex;
    }

    public void setFlex(String flex) {
        this.flex = flex;
    }

    public String getBend() {
        return bend;
    }

    public void setBend(String bend) {
        this.bend = bend;
    }
}
