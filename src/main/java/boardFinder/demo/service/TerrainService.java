package boardFinder.demo.service;

import boardFinder.demo.domain.Terrain;
import boardFinder.demo.repository.TerrainRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for Terrain Entity class. 
 * @author Erik
 */
@Service
public class TerrainService {

    private TerrainRepository terrainRepository;

    @Autowired
    public TerrainService(TerrainRepository terrainRepository) {
        this.terrainRepository = terrainRepository;
    }

    /** 
     * Gets all terrains.
     * @return a list of all Terrains
     */
    public List<Terrain> getAllTerrains() {
        return terrainRepository.findAll();
    }

    /** 
     * Gets a Terrain by it's id. 
     * @param id as Long
     * @return Terrain or Optional if no match.
     */
    public Optional<Terrain> getTerrainById(Long id) {
        return terrainRepository.findById(id);
    }

    /** 
     * Saves a Terrain
     * @param Terrain to save
     * @return the saved Terrain.
     */
    public Terrain save(Terrain terrain) {
        return terrainRepository.save(terrain);
    }

}
