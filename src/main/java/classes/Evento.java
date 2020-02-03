package classes;

import java.util.Collection;
import java.util.Date;

public class Evento {

	private Collection<Prenotazione> mapUserPrenotazioni;

	public Collection<Prenotazione> getMapUserPrenotazioni() {
		return mapUserPrenotazioni;
	}

	public void setMapUserPrenotazioni(Collection<Prenotazione> mapUserPrenotazioni) {
		this.mapUserPrenotazioni = mapUserPrenotazioni;
	}

	private QLessFood qLessFood;

	public Evento newEvento(String Nome, Date Data, int PostiTotali, double Prezzo, int Sconto) {
		return null;
	}

	public void aggiungiPrenotazione(Prenotazione pr) {
	}


	public double calcolaPrezzoTotale(int QuantitaRichiesta, double Prezzo, int Sconto) {
		return 0;
	}

	public void decreasePostiTotali(int QuantitaRichiesta) {

	}

	public void getMappaPrenotazioni() {

	}

	public void visualizzaMappaPrenotazioni() {

	}

}
