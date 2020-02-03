package classes;

public class Menù {

	private double Prezzo;

	private MenuPasto menuPasto;

	public Menù() {
	}

	public Menù(double prezzo, MenuPasto menuPasto) {
		Prezzo = prezzo;
		this.menuPasto = menuPasto;
	}

	public double getPrezzo() {
		return Prezzo;
	}

	public void setPrezzo(double prezzo) {
		Prezzo = prezzo;
	}

	public MenuPasto getMenuPasto() {
		return menuPasto;
	}

	public void setMenuPasto(MenuPasto menuPasto) {
		this.menuPasto = menuPasto;
	}
}
