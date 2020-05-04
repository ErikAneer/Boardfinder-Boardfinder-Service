
package boardFinder.demo.service;

import boardFinder.demo.domain.RidingTerrain;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import boardFinder.demo.repository.RidingTerrainRepository;

/**
 * Service class for the Riding Terrain Entity class.
 * @author Erik
 */
@Service
public class RidingTerrainService {
    
    private RidingTerrainRepository rTRepository;

    @Autowired
    public RidingTerrainService(RidingTerrainRepository rTRepository) {
        this.rTRepository = rTRepository;
    }
    
    /** 
     * Gets all RidingTerrains. 
     * @return list of RidingTerrains
     */
    public List<RidingTerrain> getAllRidingTypes(){
        return rTRepository.findAll();
    }
    
    /** 
     * Gets a RidingTerrain by it's id. 
     * @param id as Long.
     * @return RidingTerrain or optional if no match. 
     */
    public Optional<RidingTerrain> getRidingTypeById(Long id){
        return rTRepository.findById(id);
    }
    
    /** 
     * Saves a RidingTerrain.
     * @param RidingTerrain to save.
     * @return the saved RidingTerrain.
     */
    public RidingTerrain save(RidingTerrain rT){
        return rTRepository.save(rT);
    }
}
