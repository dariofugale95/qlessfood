package classes;

import java.sql.Time;
import java.util.Collection;

public class Ordine extends StatoOrdine{

    private static int IdOrdine=0;

    private Time FasciaOraria;

    private boolean TipoPagamento;

    private MenuPasto menuPasto;

    private QLessFood qLessFood;

    private Fattura fattura;


    private Collection<Token> token;

    private Cliente cliente;

    private StatoOrdine statoOrdine;

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

    @Override
    public void gestioneStatoOrdine() {

    }
}
