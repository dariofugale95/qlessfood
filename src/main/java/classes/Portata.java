package classes;

import java.util.Collection;

public class Portata {

	private static int IdPortata = 0;

	private int Tipo;

	private String Descrizione;

	private Collection<MenuPasto> menuPasto;

	public Portata newPortata(int Tipo, String Descrizione) {
		return null;
	}

	public Portata() {
	}

	public Portata(int tipo, String descrizione) {
		IdPortata++;
		Tipo = tipo;
		Descrizione = descrizione;
	}

	public int getIdPortata() {
		return IdPortata;
	}

	public void setIdPortata(int idPortata) {
		IdPortata = idPortata;
	}

	public int getTipo() {
		return Tipo;
	}

	public void setTipo(int tipo) {
		Tipo = tipo;
	}

	public String getDescrizione() {
		return Descrizione;
	}

	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
}
