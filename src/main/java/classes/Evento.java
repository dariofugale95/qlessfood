package classes;

import java.util.*;

public class Evento {

	private String Nome;

	private Date Data;

	private int PostiTotali;

	private double Prezzo;

	private int Sconto;

	public Evento() {
	}

	public Evento(String nome, Date data, int postiTotali, double prezzo, int sconto) {
		this.Nome = nome;
		this.Data = data;
		this.PostiTotali = postiTotali;
		this.Prezzo = prezzo;
		this.Sconto = sconto;
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

	private Map<String,Prenotazione> mapUserPrenotazioni = new HashMap<>();


	public void aggiungiPrenotazione(Prenotazione pr) {
		double prezzoScontato = calcolaPrezzoTotale(pr.getQuantitaRichiesta(), this.getPrezzo(), this.getSconto());
		pr.setPrezzoTotale(prezzoScontato);
		decreasePostiTotali(pr.getQuantitaRichiesta());
		mapUserPrenotazioni.put(pr.getUsername(),pr);
	}


	public double calcolaPrezzoTotale(int QuantitaRichiesta, double Prezzo, int Sconto) {
		return (Prezzo-(Prezzo*Sconto)/100)*QuantitaRichiesta;
	}

	public void decreasePostiTotali(int QuantitaRichiesta) {
		this.setPostiTotali(this.getPostiTotali()-QuantitaRichiesta);
	}

	public void visualizzaMappaPrenotazioni() {
		for(Map.Entry<String,Prenotazione> entry: mapUserPrenotazioni.entrySet()){
			System.out.println(entry.toString());
		}
	}
}
