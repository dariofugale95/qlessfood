package classes;

import java.util.*;

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

	public List<Portata> getListPortate() {
		return listPortate;
	}

	public void setListPortate(List<Portata> listPortate) {
		this.listPortate = listPortate;
	}

	public MenuPasto newMenu(Date Data, int Tipologia, double Prezzo, List<Integer> ListaIdPortate) {
		return null;
	}

	public boolean addToMenu(int Tipo, String Descrizione) {
		Portata portata = new Portata(Tipo, Descrizione);
		if(listPortate.add(portata))
			return true;
		return false;
	}


	public boolean updatePortata(int IdPortataOld, int newTipo, String newDescrizione) {
		Portata newPortata = new Portata(newTipo, newDescrizione);
		int index = 0;
		Portata oldPortata = null;
		for (Portata portata : listPortate) {
			if (portata.getIdPortata() == IdPortataOld) {
				oldPortata = listPortate.get(index);
				break;
			}
			index++;
		}

		return Collections.replaceAll(listPortate, oldPortata, newPortata);
	}

	public boolean removePortata(int IdPortata) {
		for(Portata portata : listPortate){
			if(portata.getIdPortata() == IdPortata){
				return listPortate.remove(portata);
			}
		}
		return false;
	}
}
