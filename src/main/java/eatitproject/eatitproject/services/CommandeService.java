package eatitproject.eatitproject.services;



import java.util.List;

import eatitproject.eatitproject.models.Commande;



public interface CommandeService {
    List<Commande> getAllCommandes();

    Commande getCommandeById(Long id);

    Commande updateCommande(Commande commande);

    void deleteCommande(Long id);


	Commande createCommande(Commande commande);

}
