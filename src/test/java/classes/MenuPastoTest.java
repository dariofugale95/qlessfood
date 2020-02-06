package classes;

import org.junit.jupiter.api.*;

import java.awt.*;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MenuPastoTest {

    @Test
    void addToMenu() {
        Date date = new Date();
        MenuPasto menuPasto = new MenuPasto(date,1,20);

        assertTrue(menuPasto.addToMenu(1,"carne alla brace"));
    }

    @Test
    void updatePortata() {
        Date date = new Date();
        MenuPasto menuPasto = new MenuPasto(date,1,20);
        menuPasto.addToMenu(1,"risotto");

        assertTrue(menuPasto.updatePortata(1,0,"risotto ai funghi"));

    }

    @Test
    void removePortata() {
        Date date = new Date();
        MenuPasto menuPasto = new MenuPasto(date,1,20);
        menuPasto.addToMenu(1,"risotto");

        assertTrue(menuPasto.removePortata(1));

    }

}