package classes;

import java.util.Collection;

public class MenuPasto {

	public MenuPasto() {

	}

	public MenuPasto(DateTime data, int tipologia, double prezzo) {
		Data = data;
		Tipologia = tipologia;
		Prezzo = prezzo;
	}

	private DateTime Data;

	private int Tipologia;

	private double Prezzo;

	private QLessFood qLessFood;

	private Menù menù;

	public DateTime getData() {
		return Data;
	}

	public void setData(DateTime data) {
		Data = data;
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

	public Menù getMenù() {
		return menù;
	}

	public void setMenù(Collection<Menù> menù) {
		this.menù = menù;
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

	public void setMenù(Menù menù) {
		this.menù = menù;
	}

	private Collection<Menù> menù;

	private Collection<Ordine> ordine;

	private Portata listPortate {list};

	private QLessFood qLessFood;

	private Collection<Ordine> ordine;

	public MenuPasto newMenu(DateTime Data, int Tipologia, double Prezzo, int ListaIdPortate) {
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
