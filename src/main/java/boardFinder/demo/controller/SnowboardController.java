/*

 */
package boardFinder.demo.controller;

import boardFinder.demo.domain.Snowboard;
import boardFinder.demo.service.SnowboardService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Erik
 */

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/board")
public class SnowboardController {

    private SnowboardService sbService;

    @Autowired
    public SnowboardController(SnowboardService sbService) {
        this.sbService = sbService;
    }

    @GetMapping
    public List<Snowboard> getAllSnowboards() {
        return sbService.getAllSnowboards();
    }

     @GetMapping( "/{id}")
    public Snowboard getSnowboardById(@PathVariable Long id) {
        System.out.println("Enetered getSnowboardById");
        
        return sbService.findBoardById(id);
    }

    @GetMapping("/boardsbyids{ids}")
    public List<Snowboard> getSnowboardsByIds(@PathVariable String[] ids) {
        return sbService.filterByIds(ids);
    }
    
    @PostMapping("/filter")
    public List<Snowboard> filterSnowboards(@RequestBody Map<String, Object> map) {
        return sbService.filter(map);
    }

    @PostMapping("/filteralternative")
    public List<Snowboard> filterSnowboardsWithAlternativeBendAndShape(@RequestBody Map<String, Object> map) {
        return sbService.filterWithAlternativeBendAndShape(map);
    }

    @PostMapping("/recommendedlength")
    public List<String> getRecommendedBoardLengths(@RequestBody Map<String, Object> map) {
        return sbService.getRecommendedBoardLengths(map);
    }

}
