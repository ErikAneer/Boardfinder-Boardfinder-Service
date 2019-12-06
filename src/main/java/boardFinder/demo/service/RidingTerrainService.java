
package boardFinder.demo.service;

import boardFinder.demo.domain.RidingTerrain;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import boardFinder.demo.repository.RidingTerrainRepository;

/**
 *
 * @author Erik
 */
@Service
public class RidingTerrainService {
    
    private RidingTerrainRepository rTRepository;

    @Autowired
    public RidingTerrainService(RidingTerrainRepository rTRepository) {
        this.rTRepository = rTRepository;
    }
    
    public List<RidingTerrain> getAllRidingTypes(){
        return rTRepository.findAll();
    }
    
    public Optional<RidingTerrain> getRidingTypeById(Long id){
        return rTRepository.findById(id);
    }
    
    public RidingTerrain save(RidingTerrain rT){
        return rTRepository.save(rT);
    }
}
