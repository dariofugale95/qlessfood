package classes;

public class Prenotazione {

	private String Username;

	private int QuantitaRichiesta;

	private double PrezzoTotale;

	private String NomeEventoRichiesto;

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getNomeEventoRichiesto() {
		return NomeEventoRichiesto;
	}

	public void setNomeEventoRichiesto(String nomeEventoRichiesto) {
		NomeEventoRichiesto = nomeEventoRichiesto;
	}

	public Prenotazione newPrenotazione(int QuantitaRichiesta) {
		return null;
	}

	public void updatePrezzoTotale(double prezzoTotale) {

	}

	public Prenotazione() {
	}

	public Prenotazione(int quantitaRichiesta, String nomeEventoRichiesto, String username) {
		QuantitaRichiesta = quantitaRichiesta;
		NomeEventoRichiesto = nomeEventoRichiesto;
		Username = username;
		PrezzoTotale = 0;

	}

	public int getQuantitaRichiesta() {
		return QuantitaRichiesta;
	}

	public void setQuantitaRichiesta(int quantitaRichiesta) {
		QuantitaRichiesta = quantitaRichiesta;
	}

	public double getPrezzoTotale() {
		return PrezzoTotale;
	}

	public void setPrezzoTotale(double prezzoTotale) {
		PrezzoTotale = prezzoTotale;
	}
}
