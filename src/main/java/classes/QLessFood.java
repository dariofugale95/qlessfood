package classes;

import interfaces.Observable;
import interfaces.Observer;
import interfaces.StatoOrdine;
import org.jdesktop.swingx.tips.TipOfTheDayModel;

import javax.sound.sampled.Port;
import java.awt.*;
import java.lang.ref.Cleaner;
import java.sql.Time;
import java.util.*;
import java.util.List;

public class QLessFood implements Observer {

	private static QLessFood qLessFood; //intanze singleton

	private MenuPasto menuPasto;
	private Map<String, MenuPasto> mapMenuPasto = new HashMap<>();

	private Ordine ordine;
	private List<Ordine> listOrdini = new ArrayList<>();

	private Token token;
	private Cliente cliente;
	private Evento evento;
	private Prenotazione prenotazione;

	public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    private List<Token> listToken = new ArrayList<>();

	private List<Cliente> listClienti = new ArrayList<>();

	private Map<String,Integer> mapUserToken = new HashMap<>();

	private String isPaymentVerified;

	public String getIsPaymentVerified() {
		return isPaymentVerified;
	}

	public void setIsPaymentVerified(String isPaymentVerified) {
		this.isPaymentVerified = isPaymentVerified;
	}

	public List<Cliente> getListClienti() {
		return listClienti;
	}

	public void setListClienti(List<Cliente> listClienti) {
		this.listClienti = listClienti;
	}

	private Collection<Evento> listEventi;

	private Observer observer;

	private QLessFood() { }

	public static QLessFood getInstance() {
		if(qLessFood == null) {
			qLessFood = new QLessFood();
		}
		return qLessFood;
	}

	public void gestisciMenu(String scelta) {

	}

	public void inserisciMenu(Date Data, int Tipologia, double Prezzo) {
		menuPasto = new MenuPasto(Data, Tipologia, Prezzo);
	}

	public int confermaDatiMenu() {
		String IdMenuPasto = menuPasto.getData()+"-"+String.valueOf(menuPasto.getTipologia());
		if(mapMenuPasto.put(IdMenuPasto, menuPasto) != null)
			return 1;
		return 0;
	}

	public MenuPasto ricercaMenu(Date Data, int Tipologia) {
		return mapMenuPasto.get(menuPasto.getData()+"-"+String.valueOf(menuPasto.getTipologia()));
	}

	public boolean modificaMenu(MenuPasto menuPastoOld, Date newData, int newTipologia, double newPrezzo) {
		eliminaMenu(menuPastoOld);
		inserisciMenu(newData, newTipologia, newPrezzo);
		int res = confermaDatiMenu();
		if(res == 1)
			return true;
		return false;
	}

	public boolean inserisciPortata(int Tipo, String Descrizione) {
		return menuPasto.addToMenu(Tipo,Descrizione);
	}

	public void modificaPortata(String SceltaPortata) {
	}

	public boolean eliminaPortata(int IdPortata) {
		return menuPasto.removePortata(IdPortata);
	}

	public boolean modificaDatiPortata(int IdPortataOld, int newTipo, String newDescrizione) {
		return menuPasto.updatePortata(IdPortataOld, newTipo, newDescrizione);
	}

	public boolean removePortata(int IdPortata) {
		return false;
	}

	public boolean eliminaMenu(MenuPasto menuPasto) {
		String IdMenuPasto = menuPasto.getData()+"-"+String.valueOf(menuPasto.getTipologia());
		MenuPasto mp = mapMenuPasto.remove(IdMenuPasto);
		if(mp == null){
			return false;
		}
		return true;
	}


	public List<Portata> nuovoOrdine(Date Data, int Tipologia) {
		ordine = new Ordine();
		StatoNuovo statoNuovo = new StatoNuovo();
		statoNuovo.gestioneStatoOrdine(ordine);

		MenuPasto mp = ricercaMenu(Data,Tipologia);
		ordine.setTotale(mp.getPrezzo());
		return this.getListPortate(mp);
	}

	public void selezionaPortata(int IdPortata, Date Data, int Tipologia) {
		MenuPasto mp = ricercaMenu(Data, Tipologia);
		List<Portata> listPortate = mp.getListPortate();
		Portata portata = null;
		for (Portata p : listPortate) {
			if (IdPortata == p.getIdPortata()) {
				portata = p;
				ordine.addPortataToMenu(portata);
				return;
			}
		}

	}

	public List<Portata> getListPortate(MenuPasto menuPasto) {
		return menuPasto.getListPortate();
	}

	public Portata getPortata(int IdPortata) {
		return null;
	}

	public void selezionaFasciaOraria(Time FasciaOraria) {
		ordine.setFasciaOraria(FasciaOraria);

	}

	public void sceltaMetodoPagamento(boolean Scelta) {

	}

	public String inserisciDatiCarta(String NumCarta, String NomeIntestatario, String CognomeIntestatario, int CVV, String DataScadenza) {
		String data = "Numero Carta: "+NumCarta+
				" Nome: "+NomeIntestatario+" Cognome: "+CognomeIntestatario+
				"CVV: "+String.valueOf(CVV)+" Data di scandenza: "+DataScadenza;
		this.requestVerification(data);
		return data;
	}

	public boolean pagamentoOrdineOnline() {
		if(this.getIsPaymentVerified() == "verified"){
			// pagamento online
			ordine.setTipoPagamento(true);
			return true;
		}
		else{
			// verifica non andata a buon fine => pagamento in cassa
			ordine.setTipoPagamento(false);
			return false;
		}
	}

	public void requestVerification(String DatiCarta){
		System.out.println("Dati del cliente: "+DatiCarta+" ---- Verificati!");
		this.setIsPaymentVerified("verified");
	}

	public int confermaDatiNuovoOrdine(){
		System.out.println(ordine.getIdOrdine());
		StatoInPreparazione statoInPreparazione = new StatoInPreparazione();
		statoInPreparazione.gestioneStatoOrdine(ordine);

		if(listOrdini.add(ordine)){
			return 1;
		}
		else{
			return 0;
		}

	}

	public void visualizzaOrdiniInPreparazione() {
		for (Ordine ordine: listOrdini) {
			if(ordine.getStatoOrdine().equals(StatoInPreparazione.class)){
				System.out.println(ordine.toString());
			}
		}
	}

	public Ordine confermaOrdine(int IdOrdine) {
		for (Ordine o: listOrdini) {
			if(ordine.getIdOrdine() == IdOrdine){
				StatoPronto statoPronto = new StatoPronto();
				statoPronto.gestioneStatoOrdine(ordine);
				return ordine;
			}
		}
		return null;
	}

	public Fattura scanQRCode(int IdOrdine) {
		for (Ordine ordine : listOrdini) {
			if(ordine.getIdOrdine() == IdOrdine){
				return new Fattura(ordine.isTipoPagamento(),ordine.getTotale());
			}
		}
		return null;
	}

	public void setOrdinePagato(int IdOrdine, String Username) {
		for (Ordine ordine: listOrdini) {
			if(ordine.getIdOrdine() == IdOrdine){
				StatoPagato statoPagato = new StatoPagato();
				statoPagato.gestioneStatoOrdine(ordine);

				Cliente cliente = getClienteByUsername(Username);
				if(cliente == null){
					return;
				}
				cliente.setState();
			}
		}
	}

	public Cliente getClienteByUsername(String Username){
		for(Cliente cliente: listClienti){
			if(cliente.getUsername().equals(Username)){
				return cliente;
			}
		}
		return null;
	}

	public boolean inserisciDatiToken(int Nome, int NumPasti) {
		token = new Token(Nome,NumPasti);
		if(token != null){
		    return true;
        }
		else{
		    return false;
        }
	}

	public void gestisciToken(String Scelta) {

	}

	public int confermaDatiToken() {
	    if(token == null){
	        return 0;
        }
	    else{
	        listToken.add(this.token);
            return 1;
        }
	}

	public Token ricercaToken(int Nome) {
        for (Token t : listToken) {
            if(t.getNome() == Nome){
                return t;
            }
        }
        return null;
	}

	public boolean modificaToken(String SceltaModifica) {
		return false;
	}

	public boolean modificaNomeToken(int oldNome, int newNome) {
        Token oldToken = ricercaToken(oldNome);
	    Token newToken = new Token(newNome,oldToken.getNumPasti());
	    return Collections.replaceAll(listToken, oldToken, newToken);
	}

	public boolean modificaNumeroPasti(int oldNome, int newNumPasti) {
		Token oldToken = ricercaToken(oldNome);
		Token newToken = new Token(oldToken.getNome(), newNumPasti);
		return Collections.replaceAll(listToken, oldToken, newToken);
	}

	public boolean modificaTutto(int oldNome, int newNome, int newNumPasti) {
	    Token oldToken = ricercaToken(oldNome);
	    Token newToken = new Token(newNome, newNumPasti);
		return Collections.replaceAll(listToken, oldToken, newToken);
	}

	public boolean eliminaToken(int Nome) {
	    for(Token t : listToken){
		    if(t.getNome() == Nome){
		        return listToken.remove(t);
            }
        }
	    return false;
	}

	public Ordine getOrdineById(int IdOrdine){
		for(Ordine ordine : listOrdini){
			if(ordine.getIdOrdine() == IdOrdine){
				return ordine;
			}
		}
		return null;
	}
	public void utilizzaToken(int NomeToken, int IdOrdine) {
		Ordine ordine = getOrdineById(IdOrdine);
		if(ordine != null){
			double prezzoIntero = ordine.getTotale();
			double prezzoScontato = this.calcolaPrezzoFinale(NomeToken,prezzoIntero);
			this.ordine = ordine;
			this.ordine.setTotale(prezzoScontato);
			Collections.replaceAll(listOrdini,ordine,this.ordine);
		}
	}

	public int confermaUtilizzoToken(String Username) {
		return mapUserToken.remove(Username);
	}

	public int getUserToken(String Username){
		int value = mapUserToken.get(Username);
		return value;
	}

	public void gestisciCliente(String Scelta) {

	}

	public void inserisciDatiCliente(String Username, String Email, String Password) {
		cliente = new Cliente(Username, Email, Password);

	}

	public int confermaDatiCliente() {
		listClienti.add(this.cliente);
		return 1;
	}



	public Cliente ricercaCliente(String Username) {
		for(Cliente cliente : listClienti){
			if(cliente.getUsername().equals(Username)) {
				return cliente;
			}
		}
		return null;
	}

	public boolean confermaEliminaCliente(String Username) {
		Cliente cliente = ricercaCliente(Username);
		return listClienti.remove(cliente);
	}

	public void visualizzaListaClienti() {
		for(Cliente cliente : listClienti){
			System.out.println(cliente.toString());
		}
	}

	public double calcolaPrezzoFinale(int NomeToken, double prezzo) {
		return prezzo-((prezzo*NomeToken)/100);
	}

	public void gestisciEvento(String Scelta) {

	}

	public void inserisciDatiEvento(String Nome, Date Data, int PostiTotali, double Prezzo, int Sconto) {
		this.evento = new Evento(Nome, Data, PostiTotali, Prezzo, Sconto);
	}


	public int confermaDatiEvento() {
		listEventi.add(this.evento);
		return 1;
	}

	public Evento ricercaEvento(String NomeEvento) {
		for(Evento evento : listEventi){
			if(evento.getNome() == NomeEvento){
				return evento;
			}
		}
		return null;
	}

	public boolean confermaEliminaEvento(String NomeEvento) {
		Evento evento = ricercaEvento(NomeEvento);
		return listEventi.remove(evento);
	}

	public void selezionaEvento(Date Data) {

	}

	public void inserisciPostiPrenotazione(int QuantitaRichiesta, String NomeEventoRichiesto, String Username) {
		this.prenotazione = new Prenotazione(QuantitaRichiesta, NomeEventoRichiesto, Username);
	}

	public int confermaDatiPrenotazione() {
		Evento evento = ricercaEvento(this.prenotazione.getNomeEventoRichiesto());
		if(this.prenotazione.getQuantitaRichiesta() < evento.getPostiTotali()){
			evento.aggiungiPrenotazione(this.prenotazione);
			return 1;
		}
		return 0;
	}

	public void ricercaPrenotazioniEvento(String NomeEvento) {
		Evento evento = ricercaEvento(NomeEvento);
		evento.visualizzaMappaPrenotazioni();
	}

	public void visualizzaListaOrdini() {
		for (Ordine o: listOrdini) {
			System.out.println(o.getIdOrdine());
		}
	}

	public boolean verifyIfToken(Cliente c) {
	    int res = c.getNumOrdini() % listToken.get(listToken.size() - 1).getNumPasti();
        for (Token t : listToken) {
            if(res == t.getNumPasti()){
                mapUserToken.put(c.getUsername(),t.getNome());
                return true;
            }
        }
        return false;
	}

	public void verifyIfTokenStartup(Cliente c){
		mapUserToken.put(c.getUsername(),0);
	}


	/**
	 * @see 4-DCD - DiagrammaClassiProgetto.Observer#update(4-DCD - DiagrammaClassiProgetto.Observable, Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		Cliente cliente = (Cliente) o;
		verifyIfToken(cliente);
	}
}
