import java.util.Collection;

public class Token implements Observable {

	private int Nome;

	/**
	 * Numero di pasti per accedere al token
	 * 
	 */
	private int NumPasti;

	private QLessFood qLessFood;

	private Collection<Cliente> cliente;

	private Collection<Ordine> ordine;

	private Observable observable;

	public Token newToken(int newNome, int newNumPasti) {
		return null;
	}

	public boolean removeToken(Token t) {
		return false;
	}


	/**
	 * @see 4-DCD - DiagrammaClassiProgetto.Observable#addObserver(4-DCD - DiagrammaClassiProgetto.Observer)
	 */
	public void addObserver(Observer o) {

	}


	/**
	 * @see 4-DCD - DiagrammaClassiProgetto.Observable#deleteObserver(4-DCD - DiagrammaClassiProgetto.Observer)
	 * 
	 *  
	 */
	public void deleteObserver(Observer o) {

	}


	/**
	 * @see 4-DCD - DiagrammaClassiProgetto.Observable#notifyObserver(4-DCD - DiagrammaClassiProgetto.Observer)
	 */
	public void notifyObserver(Observer o) {

	}

}
