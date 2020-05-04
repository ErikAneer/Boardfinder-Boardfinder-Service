package boardFinder.demo.service;

import boardFinder.demo.domain.ShoeSize;
import boardFinder.demo.repository.ShoeSizeRepository;
import boardFinder.demo.repository.ShoeSizeRepositoryImpl;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Service class for the ShoeSize entity class. 
 * @author Erik
 */
@Service
public class ShoeSizeService {

    private final ShoeSizeRepository shoeSizeRepository;
    private final ShoeSizeRepositoryImpl shoeSizeRepositoryImpl;

    @Autowired
    public ShoeSizeService(ShoeSizeRepository shoeSizeRepository, ShoeSizeRepositoryImpl shoeSizeRepositoryImpl) {
        this.shoeSizeRepository = shoeSizeRepository;
        this.shoeSizeRepositoryImpl = shoeSizeRepositoryImpl;
    }

    /** 
     * Gets all ShoeSizes.
     * @return list of ShoeSizes.
     */
    public List<ShoeSize> getAllShoeSizes() {
        return shoeSizeRepository.findAll();
    }

    /** 
     * Gets a ShoeSize by it's id.
     * @param id as Long.
     * @return ShoeSize or Optional if no match.
     */
    public Optional<ShoeSize> getShoeSizeById(Long id) {
        return shoeSizeRepository.findById(id);
    }

    /** 
     * Saves a ShoeSize. 
     * @param shoeSize to save.
     * @return the saved ShoeSize. 
     */
    public ShoeSize save(ShoeSize shoeSize) {
        return shoeSizeRepository.save(shoeSize);
    }
    
    /** 
     * Gets all ShoeSizes for a gender. 
     * @param gender
     * @return list of ShoeSizes matching the gender. 
     */
    public List<ShoeSize> getAllShoeSizesByGender(String gender) {
        
        if("women".equalsIgnoreCase(gender)) {
                return shoeSizeRepositoryImpl.findShoeSizeByMinAndMax(34, 42);
        }
        if("kids".equalsIgnoreCase(gender)) {
               return shoeSizeRepositoryImpl.findShoeSizeByMinAndMax(0, 40);
        } 
        return shoeSizeRepositoryImpl.findShoeSizeByMinAndMax(40, 50);
    }
}
