package classes;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EventoTest {

    @Test
    void aggiungiPrenotazione(){
        Evento e = new Evento();
        Prenotazione pr1 = new Prenotazione(1,"effettì mense event","dariofugale");
        Prenotazione pr2 = new Prenotazione(4, "effettì mense event","luisfound");

        Map<String,Prenotazione> mapUserPrenotazioni = new HashMap<>();
        mapUserPrenotazioni.put(pr1.getUsername(),pr1);
        mapUserPrenotazioni.put(pr2.getUsername(),pr2);

        int expectedSize1 = 1;
        int expectedSize2 = 2;

        assertEquals(expectedSize2,mapUserPrenotazioni.size());
        assertNotEquals(expectedSize1,mapUserPrenotazioni.size());

        assertSame(pr1,mapUserPrenotazioni.get(pr1.getUsername()));
        assertNotSame(pr1,mapUserPrenotazioni.get(pr2.getUsername()));
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
        Evento e = new Evento();
        e.setPostiTotali(100);
        int expectedValue = 98;
        e.decreasePostiTotali(2);
        assertEquals(expectedValue, e.getPostiTotali());
        assertNotEquals(93,e.getPostiTotali());
    }
}