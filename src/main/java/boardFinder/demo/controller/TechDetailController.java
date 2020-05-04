package boardFinder.demo.controller;

import boardFinder.demo.domain.Snowboard;
import boardFinder.demo.domain.TechDetail;
import boardFinder.demo.repository.SnowboardRepository;
import boardFinder.demo.service.TechDetailsService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for snowboards' techdetails.
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
    
    /**  
     * Gets all available flexes.
     * @return list of TechDetails that represent board flexes.
     */
    @GetMapping("/flex")
    public List<TechDetail> getAllFlexes(){
        return techDetailsService.getAllFlexes();
    }
    
    /** 
     * Gets all available snowboard bends for a certain rider gender.
     * @param map that contains rider gender.
     * @return list of TechDetails that represent board bends.
     */
     @PostMapping("/bend")
    public List<TechDetail> getAllBendsByGender(@RequestBody Map<String, Object> map){
        return techDetailsService.getAllTechDetailsByType(map, "bend");   
    }
    
    /** 
     * Gets all available snowboard flexes for a certain rider gender.
     * @param map that contains rider gender.
     * @return list of TechDetails that represent board flexes.
     */
    @PostMapping("/flex")
    public List<TechDetail> getAllFlexesByGender(@RequestBody Map<String, Object> map){
        return techDetailsService.getAllTechDetailsByType(map, "flex");   
    }
    
    /** 
     * Gets all available snowboard shapes for a certain rider gender.
     * @param map that contains rider gender.
     * @return list of TechDetails that represent board shapes.
     */
    @PostMapping("/shape")
    public List<TechDetail> getAllShapesByGender(@RequestBody Map<String, Object> map){
        return techDetailsService.getAllTechDetailsByType(map, "shape");   
    }
    
    /**  
     * Gets all available bends.
     * @return list of TechDetails that represent board bends.
     */
     @GetMapping("/bend")
    public List<TechDetail> getAllBends(){
        return techDetailsService.getAllBends();
    }
    
    /**  
     * Gets all available cores.
     * @return list of TechDetails that represent board cores.
     */
     @GetMapping("/core")
    public List<TechDetail> getAllCores(){
        return techDetailsService.getAllCores();
    }
    
    /**  
     * Gets all available shapes.
     * @return list of TechDetails that represent board shapes.
     */
     @GetMapping("/shape")
    public List<TechDetail> getAllShapes(){
        return techDetailsService.getAllShapes();
    }

}

