
package boardFinder.demo.service;

import boardFinder.demo.domain.TechDetail;
import boardFinder.demo.repository.TechDetailRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erik
 */
@Service
public class TechDetailsService {

    private TechDetailRepository techDetailRepository;

    @Autowired
    public TechDetailsService(TechDetailRepository techDetailRepository) {
        this.techDetailRepository = techDetailRepository;
    }

    public List<TechDetail> getAllTechDetails() {
        return techDetailRepository.findAll();
    }

    public Optional<TechDetail> getTechDetailsById(Long id) {
        return techDetailRepository.findById(id);
    }

    public TechDetail save(TechDetail techDetail) {
        return techDetailRepository.save(techDetail);
    }
    
    public List<TechDetail> getAllBends() {
        return techDetailRepository.findByTechDetailType("bend");
    }
    
    public List<TechDetail> getAllShapes() {
        return techDetailRepository.findByTechDetailType("shape");
    }
    
    public List<TechDetail> getAllCores() {
        return techDetailRepository.findByTechDetailType("core");
    }
    
    public List<TechDetail> getAllFlexes() {
        return techDetailRepository.findByTechDetailType("flex");
    }
}
