package classes;

import java.util.Collection;
import java.util.Date;

public class Evento {

	private String Nome;
	private Date Data;
	private int PostiTotali;
	private double Prezzo;
	private int Sconto;

	public Evento() {
	}

	public Evento(String nome, Date data, int postiTotali, double prezzo, int sconto) {
		Nome = nome;
		Data = data;
		PostiTotali = postiTotali;
		Prezzo = prezzo;
		Sconto = sconto;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public int getPostiTotali() {
		return PostiTotali;
	}

	public void setPostiTotali(int postiTotali) {
		PostiTotali = postiTotali;
	}

	public double getPrezzo() {
		return Prezzo;
	}

	public void setPrezzo(double prezzo) {
		Prezzo = prezzo;
	}

	public int getSconto() {
		return Sconto;
	}

	public void setSconto(int sconto) {
		Sconto = sconto;
	}

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
