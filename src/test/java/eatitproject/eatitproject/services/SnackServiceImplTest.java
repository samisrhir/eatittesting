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

import eatitproject.eatitproject.models.Snack;
import eatitproject.eatitproject.repository.SnackRepository;

public class SnackServiceImplTest {

    @Mock
    private SnackRepository snackRepository;

    @InjectMocks
    private SnackServiceImpl snackService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveSnack() {
        Snack snackToSave = new Snack();
        snackToSave.setId(1L);
        snackToSave.setCategory("Test Category");
        snackToSave.setPrice(2.5f);

        when(snackRepository.save(snackToSave)).thenReturn(snackToSave);

     
        Snack savedSnack = snackService.save(snackToSave);

     
        assertNotNull(savedSnack);
        assertEquals(1L, savedSnack.getId());
        assertEquals("Test Category", savedSnack.getCategory());
        assertEquals(2.5f, savedSnack.getPrice());
    }

    @Test
    void testGetAllSnacks() {
        // Given
        Snack snack1 = new Snack();
        snack1.setId(1L);
        snack1.setCategory("Category 1");
        snack1.setPrice(2.0f);

        Snack snack2 = new Snack();
        snack2.setId(2L);
        snack2.setCategory("Category 2");
        snack2.setPrice(3.0f);

        when(snackRepository.findAll()).thenReturn(Arrays.asList(snack1, snack2));

      
        List<Snack> allSnacks = snackService.getAllSnacks();

     
        assertNotNull(allSnacks);
        assertEquals(2, allSnacks.size());
        assertEquals("Category 1", allSnacks.get(0).getCategory());
        assertEquals("Category 2", allSnacks.get(1).getCategory());
    }

    @Test
    void testDeleteSnackById() {
     
        Long snackIdToDelete = 1L;

       
        snackService.deleteSnackById(snackIdToDelete);

      
        verify(snackRepository, times(1)).deleteById(snackIdToDelete);
    }

    @Test
    void testGetSnackById() {
      
        Long snackId = 1L;
        Snack expectedSnack = new Snack();
        expectedSnack.setId(snackId);
        expectedSnack.setCategory("Test Category");
        expectedSnack.setPrice(2.5f);

        when(snackRepository.findById(snackId)).thenReturn(Optional.of(expectedSnack));

      
        Optional<Snack> retrievedSnack = snackService.getSnackById(snackId);

       
        assertTrue(retrievedSnack.isPresent());
        assertEquals(snackId, retrievedSnack.get().getId());
        assertEquals("Test Category", retrievedSnack.get().getCategory());
        assertEquals(2.5f, retrievedSnack.get().getPrice());
    }

}
