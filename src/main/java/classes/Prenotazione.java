package classes;

public class Prenotazione {

	private String Username;

	private int QuantitaRichiesta;

	private double PrezzoTotale;

	private String NomeEventoRichiesto;

	public Prenotazione() {
	}

	public Prenotazione(int quantitaRichiesta, String nomeEventoRichiesto, String username) {
		QuantitaRichiesta = quantitaRichiesta;
		NomeEventoRichiesto = nomeEventoRichiesto;
		Username = username;
		PrezzoTotale = 0;

	}

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
