package boardFinder.demo.service;

import boardFinder.demo.domain.RiderLevel;
import boardFinder.demo.repository.RiderLevelRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for the RiderLevel Entity class. 
 * @author Erik
 */
@Service
public class RiderLevelService {

    private RiderLevelRepository rLRepository;

    @Autowired
    public RiderLevelService(RiderLevelRepository rLRepository) {
        this.rLRepository = rLRepository;
    }

    /** 
     * Gets all RiderLevels.
     * @return list of RiderLevels.
     */
    public List<RiderLevel> getAllRiderLevels() {
        return rLRepository.findAll();
    }

    /** 
     * Gets a RiderLevel by it's id. 
     * @param id as Long
     * @return RiderLevel or Optional if no match.
     */
    public Optional<RiderLevel> getRiderLevelById(Long id) {
        return rLRepository.findById(id);
    }

    /** 
     * Saves a RiderLevel
     * @param RiderLevel to save
     * @return the saved RiderLevel.
     */
    public RiderLevel save(RiderLevel rL) {
        return rLRepository.save(rL);
    }
}
