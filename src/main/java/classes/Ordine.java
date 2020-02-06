package classes;

import interfaces.StatoOrdine;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Ordine {

    private static int counter=0;

    private int IdOrdine;

    private Time FasciaOraria;

    private boolean TipoPagamento;

    private double Totale = 0;

    private StatoOrdine statoOrdine;

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

    public double getTotale() {
        return Totale;
    }

    public void setTotale(double totale) {
        Totale = totale;
    }

    private List<Portata> listComanda = new ArrayList<>();

    public List<Portata> getListComanda() {
        return listComanda;
    }

    public void setListComanda(List<Portata> listComanda) {
        this.listComanda = listComanda;
    }

    public StatoOrdine getStatoOrdine() {
        return statoOrdine;
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


    public void setStatoOrdine(StatoOrdine statoOrdine) {
        this.statoOrdine = statoOrdine;
    }

    public int getIdOrdine() {
        return IdOrdine;
    }

    public void addPortataToMenu(Portata portata){
        Portata p = portata;
        listComanda.add(portata);
    }

    public void setFasciaOraria(Time FasciaOraria) {
        this.FasciaOraria = FasciaOraria;

    }

    public void setTipoPagamento(boolean Scelta) {

    }

}
