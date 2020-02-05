package classes;

import interfaces.StatoOrdine;

public class StatoPronto implements StatoOrdine {

	@Override
	public void gestioneStatoOrdine(Ordine ordine) {
		ordine.setStatoOrdine(this);
	}

}
