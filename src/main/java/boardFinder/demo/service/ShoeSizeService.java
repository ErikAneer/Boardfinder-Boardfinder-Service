package boardFinder.demo.service;

import boardFinder.demo.domain.ShoeSize;
import boardFinder.demo.repository.ShoeSizeRepository;
import boardFinder.demo.repository.ShoeSizeRepositoryImpl;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Erik
 */
@Service
public class ShoeSizeService {

    private ShoeSizeRepository shoeSizeRepository;
    private ShoeSizeRepositoryImpl shoeSizeRepositoryImpl;

    @Autowired
    public ShoeSizeService(ShoeSizeRepository shoeSizeRepository, ShoeSizeRepositoryImpl shoeSizeRepositoryImpl) {
        this.shoeSizeRepository = shoeSizeRepository;
        this.shoeSizeRepositoryImpl = shoeSizeRepositoryImpl;
    }

    public List<ShoeSize> getAllShoeSizes() {
        return shoeSizeRepository.findAll();
    }

    public Optional<ShoeSize> getShoeSizeById(Long id) {
        return shoeSizeRepository.findById(id);
    }

    public ShoeSize save(ShoeSize shoeSize) {
        return shoeSizeRepository.save(shoeSize);
    }
    
    public List<ShoeSize> getAllShoeSizesByGender(@RequestBody Map<String, Object> map) {
        
        System.out.println("Gender = " + map.get("gender").toString());
        if("women".equalsIgnoreCase(map.get("gender").toString())) {
                return shoeSizeRepositoryImpl.findShoeSizeByMinAndMax(34, 42);
        }
        if("kids".equalsIgnoreCase(map.get("gender").toString())) {
               return shoeSizeRepositoryImpl.findShoeSizeByMinAndMax(0, 40);
        }
        
        return shoeSizeRepositoryImpl.findShoeSizeByMinAndMax(40, 50);
    }
}
