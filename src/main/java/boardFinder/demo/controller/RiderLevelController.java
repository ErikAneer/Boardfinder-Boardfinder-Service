/*

 */
package boardFinder.demo.controller;

import boardFinder.demo.domain.RiderLevel;
import boardFinder.demo.service.RiderLevelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for riderlevels.
 * @author Erik
 */
@RestController
@RequestMapping("/riderlevel")
public class RiderLevelController {

    private RiderLevelService rLService;

    @Autowired
    public RiderLevelController(RiderLevelService rLService) {
        this.rLService = rLService;
    }

    /**
     * Gets all the riderlevels available.
     * @return list of all the RiderLevels.
     */
    @GetMapping
    public List<RiderLevel> getAllRiderLevels() {
        return rLService.getAllRiderLevels();
    }

}
