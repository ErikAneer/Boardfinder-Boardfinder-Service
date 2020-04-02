
package boardFinder.demo.service;

import boardFinder.demo.domain.Gender;
import boardFinder.demo.repository.GenderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for the Gender entity class. 
 * @author Erik
 */
@Service
public class GenderService {
    
    private GenderRepository genderRepository;

    @Autowired
    public GenderService(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }
    
    /** 
     * Gets all Genders.
     * @return list of Genders.
     */
    public List<Gender> getAllGenders(){
        return genderRepository.findAll();
    }
    
    /** 
     * Gets a Gender by it's id. 
     * @param id as Long.
     * @return Gender or Optional if no match.
     */
    public Optional<Gender> getGenderById(Long id){
        return genderRepository.findById(id);
    }
    
    /** 
     * Saves a Gender.
     * @param gender
     * @return the saved Gender. 
     */
    public Gender save(Gender gender){
        return genderRepository.save(gender);
    }
    
}
