
package boardFinder.demo.service;

import boardFinder.demo.domain.Snowboard;
import boardFinder.demo.domain.TechDetail;
import boardFinder.demo.repository.SnowboardRepository;
import boardFinder.demo.repository.TechDetailRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for TechDetail Entity class. 
 * @author Erik
 */
@Service
public class TechDetailsService {

    private TechDetailRepository techDetailRepository;
    private SnowboardRepository snowboardRepo;

    @Autowired
    public TechDetailsService(TechDetailRepository techDetailRepository, SnowboardRepository snowboardRepo) {
        this.techDetailRepository = techDetailRepository;
        this.snowboardRepo = snowboardRepo;
    }

    /** 
     * Gets all TechDetails.
     * @return list of TechDetails.
     */
    public List<TechDetail> getAllTechDetails() {
        return techDetailRepository.findAll();
    }

    /** 
     * Gets a TechDetail by it's id. 
     * @param id as Long.
     * @return a TechDetail or Optional if no match. 
     */
    public Optional<TechDetail> getTechDetailsById(Long id) {
        return techDetailRepository.findById(id);
    }

    /** 
     * Saves a TechDetail. 
     * @param TechDetailto save.
     * @return the saved TechDetail.
     */
    public TechDetail save(TechDetail techDetail) {
        return techDetailRepository.save(techDetail);
    }
    
    /** 
     * Gets all TechDetails available for a given gender by the TechDetail name as String. 
     * @param map containing the rider Gender.
     * @param type of the TechDetail to find. 
     * @return list of matching TechDetails. 
     */  
    public List<TechDetail> getAllTechDetailsByType(Map<String, Object> map, String type) {
         List<TechDetail> techDetails = techDetailRepository.findByTechDetailType(type);
         List<Snowboard> boards = filterByGender(snowboardRepo.findAll(), map.get("gender").toString());
         List<TechDetail> filteredList = new ArrayList();
         techDetails.forEach((techDetail) -> {
             boards.forEach((board) -> {
                 board.getTechDetails().stream().filter((td) -> (td.equals(techDetail))).forEachOrdered((_item) -> {
                     if(!techDetail.getName().equalsIgnoreCase("Flat Top™ with Easy Bevel")) {
                     filteredList.add(techDetail);
                     }
                 });
             });
        });
         return sortTechDetailsInAlphabeticalOrder(filteredList.stream().distinct().collect(Collectors.toList()));
    }
    
    /** 
     * Gets all TechDetails that are bends.
     * @return list of bend TechDetails.
     */
    public List<TechDetail> getAllBends() {
        return techDetailRepository.findByTechDetailType("bend");
    }
    
     /** 
     * Gets all TechDetails that are shapes.
     * @return list of shape TechDetails.
     */
    public List<TechDetail> getAllShapes() {
        return techDetailRepository.findByTechDetailType("shape");
    }

     /** 
     * Gets all TechDetails that are cores.
     * @return list of core TechDetails.
     */
    public List<TechDetail> getAllCores() {
        return techDetailRepository.findByTechDetailType("core");
    }

     /** 
     * Gets all TechDetails that are flexes.
     * @return list of flex TechDetails.
     */
    public List<TechDetail> getAllFlexes() {
        return techDetailRepository.findByTechDetailType("flex");
    }

    /** 
     * Filters a list of Snowboards to find all boards for a certain rider gender. 
     * @param snowboardList of Snowboards. 
     * @param riderGender as String
     * @return list of matching Snowboards. 
     */
     List<Snowboard> filterByGender(List<Snowboard> snowboardList, String riderGender) {
        snowboardList = snowboardList.stream()
                .filter(s -> s.getBoardGender().getSex().equalsIgnoreCase(riderGender)).collect(Collectors.toList());
        return snowboardList;
    }
     
     /** 
      * Sorts a list of TechDetails in alphabetical order by the TechDetail name. 
      * @param techDetailList
      * @return sorted list of TechDetails.
      */
      public List<TechDetail> sortTechDetailsInAlphabeticalOrder(List<TechDetail> techDetailList) {

        Comparator<TechDetail> compareTechDetailName = (TechDetail td1, TechDetail td2) -> td1.getName().compareTo(td2.getName());
        Collections.sort(techDetailList, compareTechDetailName);

        return techDetailList;
    }
}
