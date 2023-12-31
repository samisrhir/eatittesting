package eatitproject.eatitproject.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eatitproject.eatitproject.models.Snack;
import eatitproject.eatitproject.repository.SnackRepository;



@Service
public class SnackServiceImpl implements SnackService {

    private final SnackRepository snackRepository;

    @Autowired
    public SnackServiceImpl(SnackRepository snackRepository) {
        this.snackRepository = snackRepository;
    }

    @Override
    public Snack save(Snack snack) {
        return snackRepository.save(snack);
    }

    @Override
    public List<Snack> getAllSnacks() {
        return snackRepository.findAll();
    }

    @Override
    public void deleteSnackById(Long id) {
        snackRepository.deleteById(id);
    }

    @Override
    public Optional<Snack> getSnackById(Long id) {
        return snackRepository.findById(id);
    }

        
   
}
