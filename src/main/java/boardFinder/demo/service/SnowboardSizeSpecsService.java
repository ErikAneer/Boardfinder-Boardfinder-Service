/*

 */
package boardFinder.demo.service;

import boardFinder.demo.domain.SnowboardSizeSpecs;
import boardFinder.demo.repository.SnowboardSizeSpecsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erik
 */
@Service
public class SnowboardSizeSpecsService {

    private SnowboardSizeSpecsRepository snowboardSizeSpecsRepository;

    @Autowired
    public SnowboardSizeSpecsService(SnowboardSizeSpecsRepository bendRepository) {
        this.snowboardSizeSpecsRepository = snowboardSizeSpecsRepository;
    }

    public List<SnowboardSizeSpecs> getAllSnowboardSizeSpecs() {
        return snowboardSizeSpecsRepository.findAll();
    }

    public Optional<SnowboardSizeSpecs> getSnowboardSizeSpecsById(Long id) {
        return snowboardSizeSpecsRepository.findById(id);
    }

    public SnowboardSizeSpecs save(SnowboardSizeSpecs snowboardSizeSpecs) {
        return snowboardSizeSpecsRepository.save(snowboardSizeSpecs);
    }
}
