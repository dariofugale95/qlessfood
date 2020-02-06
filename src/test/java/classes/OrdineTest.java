package classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdineTest {

    private Ordine o;
    private Portata p;

    @BeforeEach
    void setup(){
        o = new Ordine();
        p = new Portata(0,"piatto di pasta");
    }

    @Test
    void addPortataToMenu() {
        o.addPortataToMenu(p);
        int expected = 1;
        assertEquals(1,o.getListComanda().size());
    }
}