package boardFinder.demo.controller;

import boardFinder.demo.domain.TechDetail;
import boardFinder.demo.service.TechDetailsService;
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
@RequestMapping("/techdetails")
public class TechDetailController {
    
     private TechDetailsService techDetailsService;

    @Autowired
    public TechDetailController(TechDetailsService techDetailsService) {
        this.techDetailsService = techDetailsService;
    }
    
    @GetMapping("/flex")
    public List<TechDetail> getAllFlexes(){
        return techDetailsService.getAllFlexes();
    }
    
     @GetMapping("/bend")
    public List<TechDetail> getAllBends(){
        return techDetailsService.getAllBends();
    }
    
     @GetMapping("/core")
    public List<TechDetail> getAllCores(){
        return techDetailsService.getAllCores();
    }
    
     @GetMapping("/shape")
    public List<TechDetail> getAllShapes(){
        return techDetailsService.getAllShapes();
    }

}

