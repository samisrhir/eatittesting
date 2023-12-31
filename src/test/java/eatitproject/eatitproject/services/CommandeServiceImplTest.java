package eatitproject.eatitproject.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import eatitproject.eatitproject.models.Commande;
import eatitproject.eatitproject.repository.CommandeRepository;

public class CommandeServiceImplTest {

    @Mock
    private CommandeRepository commandeRepository;

    @InjectMocks
    private CommandeServiceImpl commandeService;

    @BeforeEach
    void setUp() {
        // Initialize mocks and inject them into the service
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCommandes() {
        // Given
        Commande commande1 = new Commande();
        commande1.setId(1L);
        commande1.setTotal(20.0);
        commande1.setState("Pending");

        Commande commande2 = new Commande();
        commande2.setId(2L);
        commande2.setTotal(30.0);
        commande2.setState("Delivered");

        when(commandeRepository.findAll()).thenReturn(Arrays.asList(commande1, commande2));

        // When
        List<Commande> allCommandes = commandeService.getAllCommandes();

        // Then
        assertNotNull(allCommandes);
        assertEquals(2, allCommandes.size());
        assertEquals("Pending", allCommandes.get(0).getState());
        assertEquals("Delivered", allCommandes.get(1).getState());
    }

    @Test
    void testGetCommandeById() {
        // Given
        Long commandeId = 1L;
        Commande expectedCommande = new Commande();
        expectedCommande.setId(commandeId);
        expectedCommande.setTotal(20.0);
        expectedCommande.setState("Pending");

        when(commandeRepository.findById(commandeId)).thenReturn(Optional.of(expectedCommande));

        // When
        Commande retrievedCommande = commandeService.getCommandeById(commandeId);

        // Then
        assertNotNull(retrievedCommande);
        assertEquals(commandeId, retrievedCommande.getId());
        assertEquals(20.0, retrievedCommande.getTotal());
        assertEquals("Pending", retrievedCommande.getState());
    }

    @Test
    void testUpdateCommande() {
        // Given
        Commande commandeToUpdate = new Commande();
        commandeToUpdate.setId(1L);
        commandeToUpdate.setTotal(25.0);
        commandeToUpdate.setState("In Progress");

        when(commandeRepository.save(commandeToUpdate)).thenReturn(commandeToUpdate);

        // When
        Commande updatedCommande = commandeService.updateCommande(commandeToUpdate);

        // Then
        assertNotNull(updatedCommande);
        assertEquals(1L, updatedCommande.getId());
        assertEquals(25.0, updatedCommande.getTotal());
        assertEquals("In Progress", updatedCommande.getState());
    }

    @Test
    void testDeleteCommande() {
        // Given
        Long commandeIdToDelete = 1L;

        // When
        commandeService.deleteCommande(commandeIdToDelete);

        // Then
        verify(commandeRepository, times(1)).deleteById(commandeIdToDelete);
    }

    @Test
    void testCreateCommande() {
        // Given
        Commande newCommande = new Commande();
        newCommande.setId(1L);
        newCommande.setTotal(30.0);
        newCommande.setState("Pending");

        when(commandeRepository.save(newCommande)).thenReturn(newCommande);

        // When
        Commande createdCommande = commandeService.createCommande(newCommande);

        // Then
        assertNotNull(createdCommande);
        assertEquals(1L, createdCommande.getId());
        assertEquals(30.0, createdCommande.getTotal());
        assertEquals("Pending", createdCommande.getState());
    }

}
