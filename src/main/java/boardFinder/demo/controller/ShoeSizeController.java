/*

 */
package boardFinder.demo.controller;

import boardFinder.demo.domain.ShoeSize;
import boardFinder.demo.service.ShoeSizeService;
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
@RequestMapping("/shoesize")
@CrossOrigin(origins = "http://localhost:4200")
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

}
