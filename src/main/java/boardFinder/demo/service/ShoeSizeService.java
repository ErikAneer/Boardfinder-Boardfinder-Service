package boardFinder.demo.service;

import boardFinder.demo.domain.ShoeSize;
import boardFinder.demo.repository.ShoeSizeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erik
 */
@Service
public class ShoeSizeService {

    private ShoeSizeRepository shoeSizeRepository;

    @Autowired
    public ShoeSizeService(ShoeSizeRepository shoeSizeRepository) {
        this.shoeSizeRepository = shoeSizeRepository;
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
}
