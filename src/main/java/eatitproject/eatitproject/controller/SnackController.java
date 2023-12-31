package eatitproject.eatitproject.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import eatitproject.eatitproject.models.Snack;
import eatitproject.eatitproject.services.SnackService;


@CrossOrigin
@RestController
@RequestMapping("/snacks")
public class SnackController {

    @Autowired
    private SnackService snackService;

    @PostMapping("/add")
    public Snack createSnack(@RequestBody Snack snack) {
        return snackService.save(snack);
    }

    @GetMapping("/all")
    public List<Snack> getAllSnacks() {
        return snackService.getAllSnacks();
    }

    @GetMapping("/{id}")
    public Optional<Snack> getSnack(@PathVariable("id") Long id) {
        return snackService.getSnackById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSnack(@PathVariable("id") Long id) {
        snackService.deleteSnackById(id);
    }

    @PutMapping("/update/{id}")
    public Snack updateSnack(@PathVariable("id") Long id, @RequestBody Snack updatedSnack) {
        Optional<Snack> existingSnack = snackService.getSnackById(id);

        if (existingSnack.isPresent()) {
            Snack snackToUpdate = existingSnack.get();
            snackToUpdate.setPicture(updatedSnack.getPicture());
            snackToUpdate.setDescription(updatedSnack.getDescription());
            snackToUpdate.setPrice(updatedSnack.getPrice());

            return snackService.save(snackToUpdate);
        } else {
            return null;
        }
    }
}
