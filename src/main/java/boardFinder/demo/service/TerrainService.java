/*

 */
package boardFinder.demo.service;

import boardFinder.demo.domain.Terrain;
import boardFinder.demo.repository.TerrainRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erik
 */
@Service
public class TerrainService {

    private TerrainRepository terrainRepository;

    @Autowired
    public TerrainService(TerrainRepository terrainRepository) {
        this.terrainRepository = terrainRepository;
    }

    public List<Terrain> getAllTerrains() {
        return terrainRepository.findAll();
    }

    public Optional<Terrain> getTerrainById(Long id) {
        return terrainRepository.findById(id);
    }

    public Terrain save(Terrain terrain) {
        return terrainRepository.save(terrain);
    }

}
