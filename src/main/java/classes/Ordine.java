package classes;

import interfaces.StatoOrdine;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Ordine {

    private static int counter=0;

    private int IdOrdine;

    private Time FasciaOraria;

    private boolean TipoPagamento;

    private double Totale = 0;

    public double getTotale() {
        return Totale;
    }

    public void setTotale(double totale) {
        Totale = totale;
    }

    private MenuPasto menuPasto;

    private QLessFood qLessFood;

    private Fattura fattura;


    private Collection<Token> token;

    private List<Portata> listComanda = new ArrayList<>();

    private Cliente cliente;

    public List<Portata> getListComanda() {
        return listComanda;
    }

    public void setListComanda(List<Portata> listComanda) {
        this.listComanda = listComanda;
    }

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
        counter++;
        IdOrdine=counter;
    }

    public Ordine(Time fasciaOraria, boolean tipoPagamento) {
        counter++;
        IdOrdine = counter;
        FasciaOraria = fasciaOraria;
        TipoPagamento = tipoPagamento;
    }

    public void addPortataToMenu(Portata portata){
        Portata p = portata;
        listComanda.add(portata);
    }

    public Ordine newOrdine() {
        return newOrdine();
    }

    public void setFasciaOraria(Time FasciaOraria) {
        this.FasciaOraria = FasciaOraria;

    }

    public void setTipoPagamento(boolean Scelta) {

    }

    public double getPrezzo() {
        return 0;
    }

    public void setPrezzo(double prezzoFinale) {

    }

}
