package classes;

import interfaces.StatoOrdine;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;

public class Ordine {

    private static int IdOrdine=0;

    private Time FasciaOraria;

    private boolean TipoPagamento;

    private MenuPasto menuPasto;

    private QLessFood qLessFood;

    private Fattura fattura;


    private Collection<Token> token;

    private ArrayList<Portata> listComande;

    private Cliente cliente;

    private StatoOrdine statoOrdine;

    public StatoOrdine getStatoOrdine() {
        return statoOrdine;
    }

    public void setStatoOrdine(StatoOrdine statoOrdine) {
        this.statoOrdine = statoOrdine;
    }

    public int getIdOrdine() {
        return IdOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        IdOrdine = idOrdine;
    }

    public Time getFasciaOraria() {
        return FasciaOraria;
    }

    public boolean isTipoPagamento() {
        return TipoPagamento;
    }

    public Ordine() {
        IdOrdine++;
    }

    public Ordine(int idOrdine, Time fasciaOraria, boolean tipoPagamento) {
        IdOrdine++;
        FasciaOraria = fasciaOraria;
        TipoPagamento = tipoPagamento;
    }

    public Ordine newOrdine() {
        return newOrdine();
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

}
