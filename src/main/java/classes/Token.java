package classes;

import java.util.Collection;

public class Token{

	private int Nome;

	/**
	 * Numero di pasti per accedere al token
	 * 
	 */
	private int NumPasti;

	private QLessFood qLessFood;

	private Collection<Cliente> cliente;

	private Collection<Ordine> ordine;


	public Token newToken(int newNome, int newNumPasti) {
		return null;
	}

	public boolean removeToken(Token t) {
		return false;
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

}
