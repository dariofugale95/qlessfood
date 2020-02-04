package classes;

import interfaces.StatoOrdine;

public class StatoPagato implements StatoOrdine {

	@Override
	public void gestioneStatoOrdine(Ordine ordine) {
		ordine.setStatoOrdine(this);
	}
}
