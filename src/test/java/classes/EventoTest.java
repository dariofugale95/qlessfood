package classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventoTest {

    @Test
    void aggiungiPrenotazione() {
    }

    @Test
    void calcolaPrezzoTotale() {
        Evento e = new Evento();
        e.calcolaPrezzoTotale(10,10,50);
        double expectedValue = (10-(10*50)/100)*10;
        assertEquals(expectedValue,e.calcolaPrezzoTotale(10,10,50));
    }

    @Test
    void decreasePostiTotali() {
    }
}