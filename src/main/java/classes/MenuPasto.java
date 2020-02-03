package classes;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;

public class MenuPasto {

	public MenuPasto() {

	}

	public MenuPasto(Time data, int tipologia, double prezzo) {
		Data = data;
		Tipologia = tipologia;
		Prezzo = prezzo;
	}

	private Time Data;

	private int Tipologia;

	private double Prezzo;

	private QLessFood qLessFood;

	public Date getData() {
		return Data;
	}

	public int getTipologia() {
		return Tipologia;
	}

	public void setTipologia(int tipologia) {
		Tipologia = tipologia;
	}

	public double getPrezzo() {
		return Prezzo;
	}

	public void setPrezzo(double prezzo) {
		Prezzo = prezzo;
	}


	public Collection<Ordine> getOrdine() {
		return ordine;
	}

	public void setOrdine(Collection<Ordine> ordine) {
		this.ordine = ordine;
	}

	public Portata getListPortate() {
		return listPortate;
	}

	public void setListPortate(Portata listPortate) {
		this.listPortate = listPortate;
	}

	public QLessFood getqLessFood() {
		return qLessFood;
	}

	public void setqLessFood(QLessFood qLessFood) {
		this.qLessFood = qLessFood;
	}

	private Collection<Menù> menù;

	private Collection<Ordine> ordine;

	private Portata listPortate;

	public MenuPasto newMenu(Date Data, int Tipologia, double Prezzo, int ListaIdPortate) {
		return null;
	}

	public boolean addToMenu(int Tipo, String Descrizione) {
		return false;
	}

	public void addPortata(Portata p) {

	}

	public boolean removeMenu() {
		return false;
	}

}
