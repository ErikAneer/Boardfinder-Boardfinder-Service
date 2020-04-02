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
 * Genereic entity class that represents a techdetail of a snowboard such as bend, shape or core.
 * @author Erik
 */
@Entity
public class TechDetail implements Serializable {

    @Id
    @SequenceGenerator(name = "techdetail_s_generator", sequenceName = "techdetail_s",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "techdetail_s_generator")
    private long id;
    private String techDetailType;
    private String name;
    
    @Length(max = 1000)
    private String description;
    private String imagePath;

    public TechDetail(String techDetailType, String name, String description, String imagePath) {
        this.techDetailType = techDetailType;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }
    
     public TechDetail() {}
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTechDetailType() {
        return techDetailType;
    }

    public void setTechDetailType(String techDetailType) {
        this.techDetailType = techDetailType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 
}
