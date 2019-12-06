
package boardFinder.demo.service;

import boardFinder.demo.domain.Gender;
import boardFinder.demo.repository.GenderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erik
 */
@Service
public class GenderService {
    
    private GenderRepository genderRepository;

    @Autowired
    public GenderService(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }
    
    public List<Gender> getAllGenders(){
        return genderRepository.findAll();
    }
    
    public Optional<Gender> getGenderById(Long id){
        return genderRepository.findById(id);
    }
    
    public Gender save(Gender gender){
        return genderRepository.save(gender);
    }
    
}
