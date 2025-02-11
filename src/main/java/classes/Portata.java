package classes;

import java.util.Collection;

public class Portata {

	private static int counter = 0;

	private int IdPortata;

	private int Tipo;

	private String Descrizione;

	public Portata() {
		counter++;
		IdPortata = counter;
	}

	public Portata(int tipo, String descrizione) {
		counter++;
		IdPortata = counter;
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
