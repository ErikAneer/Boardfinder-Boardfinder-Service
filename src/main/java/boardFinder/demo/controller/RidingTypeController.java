package boardFinder.demo.controller;

import boardFinder.demo.domain.RidingTerrain;
import boardFinder.demo.service.RidingTerrainService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for riding terrains.
 * @author Erik
 */
@RestController
@RequestMapping("/ridingterrain")
public class RidingTypeController {

    private RidingTerrainService rTService;

    @Autowired
    public RidingTypeController(RidingTerrainService rTService) {
        this.rTService = rTService;
    }

    /**
     * Gets all the riding terrains.
     * @return list with all the RidingTerrains.
     */
    @GetMapping
    public List<RidingTerrain> getAllRidingTypes() {
        return rTService.getAllRidingTypes();
    }

}
