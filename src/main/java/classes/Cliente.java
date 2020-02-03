package classes;

import java.util.Collection;

public class Cliente {
    private String Username;

    private String Password;

    private String Email;

    private Fattura fattura;

    private Token token;

    private QLessFood qLessFood;

    private Collection<Ordine> ordine;

    private Prenotazione prenotazione;

    public Cliente newCliente(String Username, String Email, String Password) {
        return null;
    }

    /**
     * Incrementa il numero di ordini del cliente
     *
     */
    public boolean setState() {
        return false;
    }

    public void notifyObservers(QLessFood qlf) {

    }

    public Cliente getState() {
        return null;
    }
}
