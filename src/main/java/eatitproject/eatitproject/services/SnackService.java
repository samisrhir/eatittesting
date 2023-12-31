package eatitproject.eatitproject.services;

import java.util.List;
import java.util.Optional;

import eatitproject.eatitproject.models.Snack;


public interface SnackService {

	Snack save(Snack snack);

	List<Snack> getAllSnacks();


	void deleteSnackById(Long id);

	Optional<Snack> getSnackById(Long id);




	
 
}
