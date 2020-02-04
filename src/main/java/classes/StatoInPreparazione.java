package classes;

import interfaces.StatoOrdine;

public class StatoInPreparazione implements StatoOrdine {

	@Override
	public void gestioneStatoOrdine(Ordine ordine) {
		ordine.setStatoOrdine(this);
	}
}
