package classes;

import interfaces.Observable;
import interfaces.Observer;

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

	public Token(int nome, int numPasti) {
		Nome = nome;
		NumPasti = numPasti;
	}

	public Token() {
	}

	public int getNome() {
		return Nome;
	}

	public void setNome(int nome) {
		Nome = nome;
	}

	public int getNumPasti() {
		return NumPasti;
	}

	public void setNumPasti(int numPasti) {
		NumPasti = numPasti;
	}

	public QLessFood getqLessFood() {
		return qLessFood;
	}

	public void setqLessFood(QLessFood qLessFood) {
		this.qLessFood = qLessFood;
	}

	public Collection<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(Collection<Cliente> cliente) {
		this.cliente = cliente;
	}

	public Collection<Ordine> getOrdine() {
		return ordine;
	}

	public void setOrdine(Collection<Ordine> ordine) {
		this.ordine = ordine;
	}

	public Observable getObservable() {
		return observable;
	}

	public void setObservable(Observable observable) {
		this.observable = observable;
	}
}
