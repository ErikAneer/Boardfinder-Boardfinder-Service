package boardFinder.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.Length;

/**
 * Entity class that represents a snowboard. 
 * @author Erik
 */
@Entity
public class Snowboard implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "brand_id")
    private Brand boardBrand;

    private String name;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "gender_id")
    private Gender boardGender;

    @ManyToMany(cascade = {CascadeType.MERGE})
    private List<Terrain> ridingterrains = new ArrayList<>();

    private double stanceSetBack;
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "warranty_id")
    private Warranty warranty;

    private String imagePath;
    @Length(max = 1000)
    private String introDescription;
    @Length(max = 1000)
    private String description;

    @ManyToMany(cascade = {CascadeType.MERGE})
    private Set<RiderLevel> riderLevels = new HashSet<>();

    @OneToMany(cascade = {CascadeType.MERGE})
    private List<SnowboardSizeSpecs> boardSizeSpecs = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "board_id")
    private List<TechDetail> techDetails = new ArrayList<>();

    private int stiffness;

    public Snowboard() {

        name = null;

        stanceSetBack = 0;
        imagePath = null;
        introDescription = null;
        description = null;
    }

    public Snowboard(Brand boardBrand, String model, Gender boardGender, double stanceSetBack,
            int stiffness, String imagePath, Warranty warranty, String introDescription, String description) {
        this.boardBrand = boardBrand;
        this.name = model;
        this.boardGender = boardGender;
        this.stanceSetBack = stanceSetBack;
        this.stiffness = stiffness;
        this.imagePath = imagePath;
        this.introDescription = introDescription;
        this.description = description;
        this.warranty = warranty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Brand getBoardBrand() {
        return boardBrand;
    }

    public void setBoardBrand(Brand boardBrand) {
        this.boardBrand = boardBrand;
    }

    public String getName() {
        return name;
    }

    public void setName(String model) {
        this.name = model;
    }

    public Gender getBoardGender() {
        return boardGender;
    }

    public void setBoardGender(Gender boardGender) {
        this.boardGender = boardGender;
    }

    public double getStanceSetBack() {
        return stanceSetBack;
    }

    public void setStanceSetBack(double stanceSetBack) {
        this.stanceSetBack = stanceSetBack;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Set<RiderLevel> getRiderLevels() {
        return riderLevels;
    }

    public void setRiderLevels(Set<RiderLevel> riderLevels) {
        this.riderLevels = riderLevels;
    }

    public String getIntroDescription() {
        return introDescription;
    }

    public void setIntroDescription(String introDescription) {
        this.introDescription = introDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Terrain> getRidingterrains() {
        return ridingterrains;
    }

    public void setRidingterrains(List<Terrain> ridingterrains) {
        this.ridingterrains = ridingterrains;
    }

    public List<SnowboardSizeSpecs> getBoardSizeSpecs() {
        return boardSizeSpecs;
    }

    public void setBoardSizeSpecs(List<SnowboardSizeSpecs> boardSizeSpecs) {
        this.boardSizeSpecs = boardSizeSpecs;
    }

    public int getStiffness() {
        return stiffness;
    }

    public void setStiffness(int stiffness) {
        this.stiffness = stiffness;
    }

    public List<TechDetail> getTechDetails() {
        return techDetails;
    }

    public void setTechDetails(List<TechDetail> techDetails) {
        this.techDetails = techDetails;
    }

    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }

    /** 
     * Gets the riding terrain value for a Snowboard by the riding terrain name. 
     * @param terrain
     * @return 
     */
    public Integer getRiderTerrainValueByName(String terrain) {
        for (Terrain t : this.ridingterrains) {
            if (t.getRidingType().getRidingTypeName().equalsIgnoreCase(terrain)) {
                return t.getValue();
            }
        }
        return 0;
    }
}
