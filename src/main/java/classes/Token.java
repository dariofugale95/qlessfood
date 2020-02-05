package classes;

import java.util.Collection;

public class Token{

	private int Nome;

	private int NumPasti;

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

}
