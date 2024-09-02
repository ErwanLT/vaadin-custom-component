package fr.eletutour.components.rating;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StarRatingTest {

    @InjectMocks
    private StarRating starRating;

    @BeforeEach
    public void setup() {
        // Initialiser le composant avec une valeur par défaut
        starRating = new StarRating();
    }

    @Test
    public void testInitialRating() {
        // Teste la valeur initiale
        assertEquals(0.0, starRating.getValue(), "La valeur initiale doit être 0.0");
    }

    @Test
    public void testSetRating() {
        // Définit une note spécifique
        starRating.setValue(3.0);
        assertEquals(3.0, starRating.getValue(), "La valeur de la note doit être 3.0");

        // Changer la note
        starRating.setValue(4.5);
        assertEquals(4.5, starRating.getValue(), "La valeur de la note doit être 4.5");
    }

    @Test
    public void testStarLayoutConfiguration() {
        // Vérifie que le layout interne des étoiles est configuré correctement
        HorizontalLayout layout = starRating.getStarLayout();
        assertEquals(5, layout.getComponentCount(), "Le layout doit contenir 5 étoiles");
    }
}
