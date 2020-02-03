package classes;

public class Prenotazione {

	private Cliente cliente;

	private int QuantitaRichiesta;

	private double PrezzoTotale;



	private Evento evento;

	public Prenotazione newPrenotazione(int QuantitaRichiesta) {
		return null;
	}

	public void updatePrezzoTotale(double prezzoTotale) {

	}

	public Prenotazione() {
	}

	public Prenotazione(int quantitaRichiesta) {
		QuantitaRichiesta = quantitaRichiesta;

	}

	public int getQuantitaRichiesta() {
		return QuantitaRichiesta;
	}

	public void setQuantitaRichiesta(int quantitaRichiesta) {
		QuantitaRichiesta = quantitaRichiesta;
	}

	public doucle getPrezzoTotale() {
		return PrezzoTotale;
	}

	public void setPrezzoTotale(doucle prezzoTotale) {
		PrezzoTotale = prezzoTotale;
	}
}
