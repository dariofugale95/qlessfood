package classes;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class MenuPasto {

	private Date Data;

	private int Tipologia;

	private double Prezzo;

	private List<Portata> listPortate = new ArrayList<>();

	public MenuPasto(Date data, int tipologia, double prezzo) {
		this.Data = data;
		this.Tipologia = tipologia;
		this.Prezzo = prezzo;
	}


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

	public List<Portata> getListPortate() {
		return listPortate;
	}

	public void setListPortate(List<Portata> listPortate) {
		this.listPortate = listPortate;
	}

	public QLessFood getqLessFood() {
		return qLessFood;
	}

	public void setqLessFood(QLessFood qLessFood) {
		this.qLessFood = qLessFood;
	}

	private Collection<Ordine> ordine;

	public MenuPasto newMenu(Date Data, int Tipologia, double Prezzo, List<Integer> ListaIdPortate) {
		return null;
	}

	public boolean addToMenu(int Tipo, String Descrizione) {
		Portata portata = new Portata(Tipo, Descrizione);
		if(listPortate.add(portata))
			return true;
		return false;
	}

	public void addPortata(Portata p) {

	}

	public boolean removeMenu() {
		return false;
	}

}
