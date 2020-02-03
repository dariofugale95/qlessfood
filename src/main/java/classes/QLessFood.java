package classes;

import interfaces.Observable;
import interfaces.Observer;

import javax.sound.sampled.Port;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class QLessFood implements Observer {

	private static QLessFood[] qLessFood;

	private Collection<MenuPasto> menuPasto;

	private Ordine ordine;

	private Collection<Ordine> listOrdini;

	private Collection<MenuPasto> mapMenuPasto;

	private Collection<Token> listToken;

	private Collection<Cliente> listClienti;

	private Collection<Evento> listEventi;

	private Observer observer;

	private QLessFood QLessFood() {
		return null;
	}

	public QLessFood getInstance() {
		return null;
	}

	public void gestisciMenu(String scelta) {

	}

	public void inserisciMenu(Date Data, int Tipologia, double Prezzo, int ListaIdPortate) {

	}

	public int confermaDatiMenu() {
		return 0;
	}

	public MenuPasto ricercaMenu(Date Data, int Tipologia) {
		return null;
	}

	public boolean modificaMenu(Date newData, int newTipologia, double newPrezzo) {
		return false;
	}

	public boolean inserisciPortata(int Tipo, String Descrizione) {
		return false;
	}

	public void modificaPortata(String SceltaPortata) {

	}

	public boolean eliminaPortata(int IdPortata) {
		return false;
	}

	public boolean modificaDatiPortata(int newTipo, String newDescrizione) {
		return false;
	}

	public boolean updatePortata(int newTipo, String newDescrizione) {
		return false;
	}

	public boolean confermaEliminazioneMenu() {
		return false;
	}

	public boolean removePortata(int IdPortata) {
		return false;
	}

	public boolean eliminaMenu() {
		return false;
	}

	public List<Portata> nuovoOrdine(Date Data, int Tipologia) {
		return null;
	}

	public void selezionaPortata(int IdPortata) {

	}

	public List<Portata> getListPortate(Date Data, int Tipologia) {
		return null;
	}

	public Portata getPortata(int IdPortata) {
		return null;
	}

	public void selezionaFasciaOraria(Time FasciaOraria) {

	}

	public void sceltaMetodoPagamento(boolean Scelta) {

	}

	public void inserisciDatiCarta(String NumCarta, String NomeIntestatario, String CognomeIntestatario, int CVV, String DataScadenza) {

	}

	public boolean pagamentoOrdineOnline() {
		return false;
	}

	public void visualizzaCodaOrdini() {

	}

	public List<Ordine> visualizzaOrdiniInPreparazione(int Stato) {
		return null;
	}

	public Ordine confermaOrdine() {
		return null;
	}

	public Fattura scanQRCode(Ordine o) {
		return null;
	}

	public void setOrdinePagato(int IdOrdine) {

	}

	public boolean inserisciDatiToken(int Nome, int NumPasti) {
		return false;
	}

	public void gestisciToken(String Scelta) {

	}

	public int confermaDatiToken() {
		return 0;
	}

	public Token ricercaToken(int Nome) {
		return null;
	}

	public boolean modificaToken(String SceltaModifica) {
		return false;
	}

	public boolean modificaNomeToken(int newNome) {
		return false;
	}

	public boolean modificaNumeroPasti(int newNumPasti) {
		return false;
	}

	public boolean modificaTutto(int newNome, int newNumPasti) {
		return false;
	}

	public boolean eliminaToken() {
		return false;
	}

	public void utilizzaToken(int nomeToken) {

	}

	public int confermaUtilizzoToken(String Username) {
		return 0;
	}

	public void gestisciCliente(String Scelta) {

	}

	public boolean inserisciDatiCliente(String Username, String Email, String Password) {
		return false;
	}

	public int confermaDatiCliente() {
		return 0;
	}

	public Cliente ricercaCliente(String Username) {
		return null;
	}

	public boolean confermaEliminaCliente() {
		return false;
	}

	public void visualizzaListaClienti() {

	}

	public double calcolaPrezzoFinale(int NomeToken, double prezzo) {
		return 0;
	}

	public void gestisciEvento(String Scelta) {

	}

	public boolean inserisciDatiEvento(String Nome, Date Data, int PostiTotali, double Prezzo, int Sconto) {
		return false;
	}

	public int confermaDatiEvento() {
		return 0;
	}

	public Evento ricercaEvento(Date Data) {
		return null;
	}

	public boolean confermaEliminaEvento() {
		return false;
	}

	public void selezionaEvento(Date Data) {

	}

	public boolean inserisciPostiPrenotazione(int QuantitaRichiesta) {
		return false;
	}

	public int confermaDatiPrenotazione() {
		return 0;
	}

	public void ricercaPrenotazioniEvento(Date DataEvento) {

	}

	public void visualizzaListaOrdini() {

	}

	public boolean verifyIfToken(Cliente c) {
		return false;
	}


	/**
	 * @see 4-DCD - DiagrammaClassiProgetto.Observer#update(4-DCD - DiagrammaClassiProgetto.Observable, Object)
	 */

	public void update(Observable o, Object arg) {

	}
}
