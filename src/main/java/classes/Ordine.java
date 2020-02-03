package classes;

import interfaces.StatoOrdine;

import java.sql.Time;
import java.util.Collection;

public class Ordine {
    private int IdOrdine;

    private Time FasciaOraria;

    private boolean TipoPagamento;

    private int Stato;

    private MenuPasto menuPasto;

    private QLessFood qLessFood;

    private Fattura fattura;


    private Collection<Token> token;

    private Cliente cliente;

    private StatoOrdine statoOrdine;

    public Ordine newOrdine() {
        return null;
    }

    public void setFasciaOraria(Time FasciaOraria) {

    }

    public void setTipoPagamento(boolean Scelta) {

    }

    public double getPrezzo() {
        return 0;
    }

    public void setPrezzo(double prezzoFinale) {

    }

    public void setStatoOrdine(int Stato) {

    }

    public void gestioneStatoOrdine() {

    }
}
