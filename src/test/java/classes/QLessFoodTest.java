package classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QLessFoodTest {

    private QLessFood qlf;
    private Date date;
    private MenuPasto menuPasto;
    private Portata portata1,portata2;
    private Cliente cliente;

    private List<Portata> listPortate;

    @BeforeEach
    void setup() throws ParseException {

        String stringData = "20/02/2020";
        date = new SimpleDateFormat("dd/MM/yyyy").parse(stringData);
        qlf = QLessFood.getInstance(); // get singleton instance

        menuPasto = new MenuPasto(date,1,20);
        portata1 = new Portata(1,"pasta al ragù");
        portata2 = new Portata(5,"birra moretti");
        listPortate = new ArrayList<>();

        cliente = new Cliente("dario","dario@mail.com","1234");


        qlf.inserisciMenu(date,1,20);
        qlf.inserisciPortata(portata1.getTipo(),portata1.getDescrizione());
        qlf.inserisciDatiCliente("dario","dario@mail.com","1234");
    }


    @Test
    void modificaMenu() {
        qlf.inserisciMenu(date,0,22);
        qlf.confermaDatiMenu();

        assertTrue(qlf.modificaMenu(menuPasto,date,1,50));
    }

    @Test
    void confermaDatiMenu() {

        int expected = 1; // return = 1 if entry added correctly in map
        assertEquals(1,qlf.confermaDatiMenu());
    }


    @Test
    void inserisciPortata() {
        assertTrue(menuPasto.addToMenu(portata2.getTipo(),portata2.getDescrizione()));
    }

    @Test
    void confermaOrdine() throws ParseException {
        Date data;
        String stringData = "22/02/2020";
        data = new SimpleDateFormat("dd/MM/yyyy").parse(stringData);

        qlf.inserisciMenu(data,0,50);
        qlf.confermaDatiMenu();

        qlf.nuovoOrdine(data,0);
        qlf.confermaDatiNuovoOrdine();

        assertNotNull(qlf.confermaOrdine(1));

    }

    @Test
    void inserisciDatiToken() {
        assertNotNull(qlf.inserisciDatiToken(20,20));
    }

    @Test
    void confermaDatiToken() {
        qlf.inserisciDatiToken(20,20);

        assertEquals(1,qlf.confermaDatiToken());
    }

    @Test
    void ricercaToken() {
        qlf.inserisciDatiToken(10,10);
        qlf.confermaDatiToken();

        assertNotNull(qlf.ricercaToken(10));
        assertNull(qlf.ricercaToken(40));
    }


    @Test
    void modificaNomeToken() {
        qlf.inserisciDatiToken(30,30);
        qlf.confermaDatiToken();

        assertTrue(qlf.modificaNomeToken(30,35));
    }

    @Test
    void modificaNumeroPasti() {
        qlf.inserisciDatiToken(32,40);
        qlf.confermaDatiToken();

        assertTrue(qlf.modificaNumeroPasti(32,30));
    }

    @Test
    void modificaTutto() {
        qlf.inserisciDatiToken(70,70);
        qlf.confermaDatiToken();

        assertTrue(qlf.modificaTutto(70,50,60));

    }

    /*
    @Test
    void confermaUtilizzoToken() throws ParseException {
        Date data;
        String stringData = "22/02/2020";
        data = new SimpleDateFormat("dd/MM/yyyy").parse(stringData);

        qlf.inserisciMenu(data,0,50);
        qlf.confermaDatiMenu();

        qlf.inserisciDatiToken(5,5);
        qlf.confermaDatiToken();

        qlf.nuovoOrdine(data,0);
        qlf.confermaDatiNuovoOrdine();

        qlf.confermaOrdine(1);

        qlf.utilizzaToken(5,1);

        int nomeToken = 5;

        qlf.inserisciDatiCliente("dario95","dariof95@mail.com","1234");
        qlf.confermaDatiCliente();

        assertEquals(nomeToken,qlf.confermaUtilizzoToken("dario95"));
    }
*/

    @Test
    void confermaDatiCliente() {
        qlf.inserisciDatiCliente("dario","dario@mail.com","1234");

        assertEquals(1,qlf.confermaDatiCliente());
    }

    @Test
    void confermaEliminaCliente() {
        qlf.inserisciDatiCliente("pippo","pippo@mail.com","1234");
        qlf.confermaDatiCliente();
        qlf.inserisciDatiCliente("luigi","ingsw@mail.com","11");
        qlf.confermaDatiCliente();
        qlf.confermaEliminaCliente("pippo");

        assertNull(qlf.ricercaCliente("pippo"));
        assertNotNull(qlf.ricercaCliente("luigi"));
    }

    @Test
    void calcolaPrezzoFinale() {
        double expected = 100-((100*10)/100);

        assertEquals(expected, qlf.calcolaPrezzoFinale(10,100));
        assertNotEquals(expected, qlf.calcolaPrezzoFinale(10,50));
    }


    @Test
    void confermaDatiEvento() {
        qlf.inserisciDatiEvento("effettì mense fest 2020",date,200,20.00,20);

        assertEquals(1, qlf.confermaDatiEvento());
    }


    @Test
    void confermaEliminaEvento() {
        qlf.inserisciDatiEvento("effettì mense fest 2020",date,100,10.00,30);
        qlf.confermaDatiEvento();

        qlf.inserisciDatiEvento("effettì fest 2050",date,200,20.00,20);
        qlf.confermaDatiEvento();

        qlf.confermaEliminaEvento("effettì fest 2050");

        assertNotNull(qlf.ricercaEvento("effettì mense fest 2020"));
        assertNull(qlf.ricercaEvento("effettì fest 2050"));
    }

    @Test
    void confermaDatiPrenotazione() {
        qlf.inserisciDatiEvento("effettì mense fest 2020",date,100,10.00,30);
        qlf.confermaDatiEvento();

        qlf.inserisciPostiPrenotazione(2,"effettì mense fest 2020","dario");

        assertEquals(1,qlf.confermaDatiPrenotazione(),"test inserimento posti prenotazione riuscito");
        assertNotEquals(0,qlf.confermaDatiPrenotazione());

    }

}