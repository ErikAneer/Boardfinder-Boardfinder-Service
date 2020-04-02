package boardFinder.demo.controller;

import boardFinder.demo.domain.Snowboard;
import boardFinder.demo.service.SnowboardService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for snowboards
 * @author Erik
 */

@RestController
@RequestMapping("/snowboards")
public class SnowboardController {

    private SnowboardService sbService;

    @Autowired
    public SnowboardController(SnowboardService sbService) {
        this.sbService = sbService;
    }

    /** 
     * Gets all the snbowboards
     * @return list of all Snowboards.
     */
    @GetMapping
    public List<Snowboard> getAllSnowboards() {
        return sbService.getAllSnowboards();
    }

    /** 
     * Gets a snowboard by it's id. 
     * @param id
     * @return a Snowboard.
     */
     @GetMapping( "/{id}")
    public Snowboard getSnowboardById(@PathVariable Long id) { 
        return sbService.findBoardById(id);
    }

    /** 
     * Gets snowboards by their ids.
     * @param string array of ids
     * @return list of Snowboards
     */
    @GetMapping("/boardsbyids{ids}")
    public List<Snowboard> getSnowboardsByIds(@PathVariable String[] ids) {
        return sbService.filterByIds(ids);
    }
    
    /** 
     * Filters all available snowboards by the parameters in the request filter objects and return the matching snowboards. None if no match. 
     * @param map
     * @return list of Snowboards.None if no match. 
     */
    @PostMapping("/filter")
    public List<Snowboard> filterSnowboards(@RequestBody Map<String, Object> map) {
        return sbService.filter(map);
    }

    /** 
     * Filters by an alternative and more board filtering. Used in client when ordinary filter give few or no matches.  
     * @param map
     * @return list of Snowboards.None if no match. 
     */
    @PostMapping("/filteralternative")
    public List<Snowboard> filterSnowboardsWithAlternativeBendAndShape(@RequestBody Map<String, Object> map) {
        return sbService.filterWithAlternativeBendAndShape(map);
    }

    /** 
     * Gets the recommended length(s) of a snowboard for the user depending on the user's filter data. 
     * @param map
     * @return list of recommended board lengths as strings. 
     */
    @PostMapping("/recommendedlength")
    public List<String> getRecommendedBoardLengths(@RequestBody Map<String, Object> map) {
        return sbService.getRecommendedBoardLengths(map);
    }

}
