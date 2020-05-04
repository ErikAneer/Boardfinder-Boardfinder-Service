package boardFinder.demo.controller;

import boardFinder.demo.domain.ShoeSize;
import boardFinder.demo.service.ShoeSizeService;
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
 * Controller class for the Shoesizes.
 * @author Erik
 */
@RestController
@RequestMapping("/shoesizes")
public class ShoeSizeController {

    private ShoeSizeService ssService;

    @Autowired
    public ShoeSizeController(ShoeSizeService ssService) {
        this.ssService = ssService;
    }
    
    /**
     * Gets all the available shoesizes from the database
     * @return list of shoesizes
     */
    @GetMapping
    public List<ShoeSize> getAllShoeSizes() {
        return ssService.getAllShoeSizes();
    }
    
        /**
     * Gets all the available shoesizes from the database for a gender
     * @param gender
     * @return list of shoesizes
     */
    @GetMapping("/{gender}")
    public List<ShoeSize> getAllShoeSizesByGender(@PathVariable String gender) {
        return ssService.getAllShoeSizesByGender(gender);
    }

}
