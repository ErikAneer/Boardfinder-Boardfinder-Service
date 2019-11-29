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
public class SnowboardSizeSpecs implements Serializable {
    
        private final static long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name="conference_room_s_generator", sequenceName = "conference_room_s",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conference_room_s_generator")
    private long id;
    
    private String boardLength;
    private int riderWeightMin;
    private int riderWeightMax;
    private String bindingSize;
    private double effectiveLength;
    private double runningLength;
    private double sidcutRadius;
    private int waistWidth;
    private double stanceWidth;

    public SnowboardSizeSpecs() {
        
         boardLength = null;
        riderWeightMin = 0;
        riderWeightMax = 0;
        bindingSize = null;
        effectiveLength = 0;
        runningLength = 0;
        sidcutRadius = 0;
        waistWidth = 0;
        stanceWidth = 0;
    }

    public SnowboardSizeSpecs(String boardLength, int riderWeightMin, int riderWeightMax, String bindingSize, double effectiveLength, double runningLength, double sidcutRadius, int waistWidth, double stanceWidth) {
        this.boardLength = boardLength;
        this.riderWeightMin = riderWeightMin;
        this.riderWeightMax = riderWeightMax;
        this.bindingSize = bindingSize;
        this.effectiveLength = effectiveLength;
        this.runningLength = runningLength;
        this.sidcutRadius = sidcutRadius;
        this.waistWidth = waistWidth;
        this.stanceWidth = stanceWidth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBoardLength() {
        return boardLength;
    }

    public void setBoardLength(String boardLength) {
        this.boardLength = boardLength;
    }

    public int getRiderWeightMin() {
        return riderWeightMin;
    }

    public void setRiderWeightMin(int riderWeightMin) {
        this.riderWeightMin = riderWeightMin;
    }

    public int getRiderWeightMax() {
        return riderWeightMax;
    }

    public void setRiderWeightMax(int riderWeightMax) {
        this.riderWeightMax = riderWeightMax;
    }

    public String getBindingSize() {
        return bindingSize;
    }

    public void setBindingSize(String bindingSize) {
        this.bindingSize = bindingSize;
    }

    public double getEffectiveLength() {
        return effectiveLength;
    }

    public void setEffectiveLength(double effectiveLength) {
        this.effectiveLength = effectiveLength;
    }

    public double getRunningLength() {
        return runningLength;
    }

    public void setRunningLength(double runningLength) {
        this.runningLength = runningLength;
    }

    public double getSidcutRadius() {
        return sidcutRadius;
    }

    public void setSidcutRadius(double sidcutRadius) {
        this.sidcutRadius = sidcutRadius;
    }

    public int getWaistWidth() {
        return waistWidth;
    }

    public void setWaistWidth(int waistWidth) {
        this.waistWidth = waistWidth;
    }

    public double getStanceWidth() {
        return stanceWidth;
    }

    public void setStanceWidth(double stanceWidth) {
        this.stanceWidth = stanceWidth;
    }

}
