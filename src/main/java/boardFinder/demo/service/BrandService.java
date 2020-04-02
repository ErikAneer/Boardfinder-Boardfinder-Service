package boardFinder.demo.service;

import boardFinder.demo.domain.Brand;
import boardFinder.demo.repository.BrandRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for the Brand entity class.
 * @author Erik
 */
@Service
public class BrandService {

    private BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    /** 
     * Gets all brands.
     * @return list of Brands
     */
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    /** 
     * Gets a Brand by it's id. Or none if no match. 
     * @param id
     * @return a Brand or Optional if no match.
     */
    public Optional<Brand> getBrandById(Long id) {
        return brandRepository.findById(id);
    }

    /** 
     * Saves a Brand.
     * @param brand to save.
     * @return the saved Brand. 
     */
    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }
}
