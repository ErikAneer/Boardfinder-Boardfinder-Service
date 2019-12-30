package boardFinder.demo.controller;

import boardFinder.demo.domain.ShoeSize;
import boardFinder.demo.service.ShoeSizeService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
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

    @GetMapping
    public List<ShoeSize> getAllShoeSizes() {
        return ssService.getAllShoeSizes();
    }
    
    @PostMapping
    public List<ShoeSize> getAllShoeSizesByGender(@RequestBody Map<String, Object> map) {
        return ssService.getAllShoeSizesByGender(map);
    }

}
