
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
 *
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

    public List<TechDetail> getAllTechDetails() {
        return techDetailRepository.findAll();
    }

    public Optional<TechDetail> getTechDetailsById(Long id) {
        return techDetailRepository.findById(id);
    }

    public TechDetail save(TechDetail techDetail) {
        return techDetailRepository.save(techDetail);
    }
    
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
    
    public List<TechDetail> getAllBends() {
        return techDetailRepository.findByTechDetailType("bend");
    }
    
    public List<TechDetail> getAllShapes() {
        return techDetailRepository.findByTechDetailType("shape");
    }

    public List<TechDetail> getAllCores() {
        return techDetailRepository.findByTechDetailType("core");
    }

    public List<TechDetail> getAllFlexes() {
        return techDetailRepository.findByTechDetailType("flex");
    }

    
     List<Snowboard> filterByGender(List<Snowboard> snowboardList, String riderGender) {
        snowboardList = snowboardList.stream()
                .filter(s -> s.getBoardGender().getSex().equalsIgnoreCase(riderGender)).collect(Collectors.toList());
        return snowboardList;
    }
     
      public List<TechDetail> sortTechDetailsInAlphabeticalOrder(List<TechDetail> techDetailList) {

        Comparator<TechDetail> compareTechDetailName = (TechDetail td1, TechDetail td2) -> td1.getName().compareTo(td2.getName());
        Collections.sort(techDetailList, compareTechDetailName);

        return techDetailList;
    }
}
