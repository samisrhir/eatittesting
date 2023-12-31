package eatitproject.eatitproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import eatitproject.eatitproject.models.Commande;



public interface CommandeRepository extends JpaRepository<Commande,Long> {

}
