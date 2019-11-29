/*

 */
package boardFinder.demo.controller;

import boardFinder.demo.domain.RidingTerrain;
import boardFinder.demo.service.RidingTerrainService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Erik
 */
@RestController
@RequestMapping("/ridingterrain")
@CrossOrigin(origins = "http://localhost:4200")
public class RidingTypeController {

    private RidingTerrainService rTService;

    @Autowired
    public RidingTypeController(RidingTerrainService rTService) {
        this.rTService = rTService;
    }

    @GetMapping
    public List<RidingTerrain> getAllRidingTypes() {
        return rTService.getAllRidingTypes();
    }

}
