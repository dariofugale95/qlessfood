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

    public Cliente() {
    }

    public Cliente(String username, String password, String email) {
        Username = username;
        Password = password;
        Email = email;
    }

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

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Fattura getFattura() {
        return fattura;
    }

    public void setFattura(Fattura fattura) {
        this.fattura = fattura;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public QLessFood getqLessFood() {
        return qLessFood;
    }

    public void setqLessFood(QLessFood qLessFood) {
        this.qLessFood = qLessFood;
    }

    public Collection<Ordine> getOrdine() {
        return ordine;
    }

    public void setOrdine(Collection<Ordine> ordine) {
        this.ordine = ordine;
    }

    public Prenotazione getPrenotazione() {
        return prenotazione;
    }

    public void setPrenotazione(Prenotazione prenotazione) {
        this.prenotazione = prenotazione;
    }
}
