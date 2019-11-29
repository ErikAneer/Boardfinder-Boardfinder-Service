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
import javax.persistence.SequenceGenerator;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Erik
 */
@Entity
public class Snowboard implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "conference_room_s_generator", sequenceName = "conference_room_s",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conference_room_s_generator")
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

    /*
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "bend_id")
    private Bend boardBend;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "shape_id")
    private Shape boardShape;
    */
    private double stanceSetBack;
    

    private String imagePath;
    @Length(max = 1000)
    private String introDescription;
    @Length(max = 1000)
    private String description;

    /*
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "flex_id")
    private Flex boardFlex;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "core_id")
    private Core core;
    */

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
            int stiffness, String imagePath, String introDescription, String description) {
        this.boardBrand = boardBrand;
        this.name = model;
        this.boardGender = boardGender;
        this.stanceSetBack = stanceSetBack;
       // this.boardBend = boardBend;
        //this.boardShape = boardShape;
        //this.boardFlex = boardFlex;
        //this.core = core;
        this.stiffness = stiffness;
        this.imagePath = imagePath;
        this.introDescription = introDescription;
        this.description = description;
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

    /*
    public Bend getBoardBend() {
        return boardBend;
    }

    public void setBoardBend(Bend boardBend) {
        this.boardBend = boardBend;
    }

    public Shape getBoardShape() {
        return boardShape;
    }

    public void setBoardShape(Shape boardShape) {
        this.boardShape = boardShape;
    } */

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

    /*
    public Flex getBoardFlex() {
        return boardFlex;
    }

    public void setBoardFlex(Flex boardFlex) {
        this.boardFlex = boardFlex;
    }
    */

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

    /*
    public Core getCore() {
        return core;
    }

    public void setCore(Core core) {
        this.core = core;
    }
*/

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
    
    public Integer getRiderTerrainValueByName(String terrain) {
        for (Terrain t : this.ridingterrains){
                if (t.getRidingType().getRidingTypeName().equalsIgnoreCase(terrain))  {
                       return  t.getValue();
                }
        }
        return 0;
    }

}
