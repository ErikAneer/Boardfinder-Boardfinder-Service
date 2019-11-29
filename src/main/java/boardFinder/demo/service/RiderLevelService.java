package boardFinder.demo.service;

import boardFinder.demo.domain.RiderLevel;
import boardFinder.demo.repository.RiderLevelRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erik
 */
@Service
public class RiderLevelService {

    private RiderLevelRepository rLRepository;

    @Autowired
    public RiderLevelService(RiderLevelRepository rLRepository) {
        this.rLRepository = rLRepository;
    }

    public List<RiderLevel> getAllRiderLevels() {
        return rLRepository.findAll();
    }

    public Optional<RiderLevel> getRiderLevelById(Long id) {
        return rLRepository.findById(id);
    }

    public RiderLevel save(RiderLevel rL) {
        return rLRepository.save(rL);
    }
}
