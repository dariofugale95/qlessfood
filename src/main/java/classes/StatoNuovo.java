package classes;

import interfaces.StatoOrdine;

public class StatoNuovo implements StatoOrdine {

    @Override
    public void gestioneStatoOrdine(Ordine ordine) {
        ordine.setStatoOrdine(this);
    }
}
