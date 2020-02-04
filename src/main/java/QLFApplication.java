import classes.*;

import javax.sound.sampled.Port;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class QLFApplication {

    private static QLessFood qLessFood;


    public static void main(String[] args) throws IOException, ParseException, InterruptedException {



        qLessFood = qLessFood.getInstance(); //singleton

        Cliente c = new Cliente();


        HashMap<Integer,String> portateMenu = new HashMap<Integer,String>();
        portateMenu.put(0, "Primo");
        portateMenu.put(1, "Secondo");
        portateMenu.put(2, "Contorno");
        portateMenu.put(3, "Bevanda");
        portateMenu.put(4, "Dolce");
        portateMenu.put(5, "Frutta");

        String data;
        Date date;
        int nomeTkn;
        int numPastiTkn;
        List<Portata> listPortate;

        while(true) {

            System.out.println("QLessFood --- Effettì Mense 2020");
            System.out.println("Seleziona l'Area d'Accesso");
            System.out.println("1. Admin access");
            System.out.println("2. Client access");
            System.out.println("3. Esci");

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            Scanner scannerIO = new Scanner(System.in);

            int mode = scannerIO.nextInt(); //mode può essere o admin o client

            switch (mode) {

                case 1: //portale admin
                    System.out.println("QLessFood - Portale Admin");
                    System.out.println("1. Gestione dei Menu");
                    System.out.println("2. Gestione dei Token-Sconto");
                    System.out.println("3. Visualizza Ordini");
                    System.out.println("4. Visualizza Clienti registrati a QLessFood");
                    System.out.println("5. Emetti una Fattura");
                    System.out.println("6. Gestisci Eventi");
                    System.out.println("7. Esci");

                    int sceltaAdmin = scannerIO.nextInt();

                    switch (sceltaAdmin) {

                        case 1: // Sezione MENU
                            System.out.println("1. Inserisci un Nuovo Menu");
                            System.out.println("2. Ricerca un Menu");
                            System.out.println("3. Modifica un Menu");
                            System.out.println("4. Elimina Menu");
                            System.out.println("5. Esci");
                            int sceltaMenu = scannerIO.nextInt();

                            switch (sceltaMenu) {

                                case 1: // inserisci menu

                                    System.out.println("--- Inserimento Menu ---");
                                    System.out.println("Inserisci Tipologia: [0: PRANZO | 1: CENA]");
                                    int tipologia = scannerIO.nextInt();
                                    System.out.println("Inserisci Data: [dd/MM/yyyy]");
                                    data = in.readLine();
                                    date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                                    System.out.println("Inserisci prezzo del Menu");
                                    double prezzo = scannerIO.nextDouble();
                                    qLessFood.inserisciMenu(date, tipologia, prezzo);

                                    System.out.println("--- Inserimento delle portate: ");
                                    for (Integer i = 0; i < 6; i++) {
                                        for (int j = 0; j < 3; j++) {
                                            System.out.println("Inserisci la " + (j + 1) + " ° portata di " + portateMenu.get(i));
                                            String descrizione = in.readLine();
                                            int a = i;
                                            qLessFood.inserisciPortata(a, descrizione);
                                        }
                                    }
                                    qLessFood.confermaDatiMenu();
                                    System.out.println("Menu inserito con successo.");

                                    continue;

                                case 2: //ricerca

                                    System.out.println("--- Ricerca Menu Pasto ---");
                                    System.out.println("Inserisci Tipologia del Pasto da ricercare[0: PRANZO | 1: CENA]");
                                    int tipo = scannerIO.nextInt();
                                    System.out.println("Inserisci Data del Pasto da ricercare: [dd/MM/yyyy]");
                                    data = in.readLine();
                                    date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                                    MenuPasto ricercaMenu = qLessFood.ricercaMenu(date, tipo);
                                    listPortate = ricercaMenu.getListPortate();
                                    System.out.println("Menu Trovato: ");
                                    for(Portata p : listPortate) {
                                        System.out.println("ID: "+p.getIdPortata()+" Descrizione: "+p.getDescrizione());
                                    }

                                    continue;

                                case 3: // modifica

                                    System.out.println("--- Modifica Menu Pasto ---");
                                    System.out.println("Inserisci Tipologia del Pasto da ricercare[0: PRANZO | 1: CENA]");
                                    int tipos = scannerIO.nextInt();
                                    System.out.println("Inserisci Data del Pasto da ricercare: [dd/MM/yyyy]");
                                    data = in.readLine();
                                    date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                                    MenuPasto ricercaMod = qLessFood.ricercaMenu(date, tipos);
                                    listPortate = ricercaMod.getListPortate();

                                    System.out.println("Menu Trovato: ");
                                    for(Portata p : listPortate) {
                                        System.out.println("ID: "+p.getIdPortata()+" Descrizione: "+p.getDescrizione());
                                    }
                                    System.out.println("Cosa vuoi modificare?");
                                    System.out.println("1. Dati del Menu");
                                    System.out.println("2. Dati delle portate del Menu");
                                    String m = in.readLine();

                                    if (m.equals("1")) { //modifico i dati del menu
                                        //new Data, new Tipologia, new Prezzo
                                        System.out.println("Inserisci nuova tipologia [0:PRANZO | 1: CENA]");
                                        int newTipologia = scannerIO.nextInt();
                                        System.out.println("Inserisci nuova Data:[dd/MM/yyyy]");
                                        String newData = in.readLine();
                                        Date newDate = new SimpleDateFormat("dd/MM/yyyy").parse(newData);
                                        System.out.println("Inserisci nuovo Prezzo: ");
                                        double newPrezzo = scannerIO.nextDouble();
                                        qLessFood.modificaMenu(ricercaMod, newDate, newTipologia, newPrezzo);

                                    } else if (m.equals("2")) {//modifico i dati delle portate
                                        ArrayList<Portata> listportate = (ArrayList<Portata>) ricercaMod.getListPortate();
                                        System.out.println("Queste sono le portate del Menu: " + listportate);
                                        System.out.println("Inserire id della portata: ");
                                        int oldId = scannerIO.nextInt();
                                        System.out.println("Inserire tipo della nuova portata: ");
                                        int newTipo = scannerIO.nextInt();
                                        System.out.println("Inserire descrizione della nuova portata: ");
                                        String newDescr = in.readLine();
                                        qLessFood.modificaDatiPortata(oldId, newTipo, newDescr);
                                    }
                                    continue;

                                case 4: // elimina

                                    System.out.println("--- Elimina Menu Pasto ---");
                                    System.out.println("Inserisci Tipologia del Pasto da eliminare[0: PRANZO | 1: CENA]");
                                    int t = scannerIO.nextInt();
                                    System.out.println("Inserisci Data del Pasto da eliminare: [dd/MM/yyyy]");
                                    String datas = in.readLine();
                                    Date datasss = new SimpleDateFormat("dd/MM/yyyy").parse(datas);
                                    MenuPasto ricerca = qLessFood.ricercaMenu(datasss, t);
                                    qLessFood.eliminaMenu(ricerca);
                                    System.out.println("Eliminazione avvenuta.");
                                    continue;


                                case 5: //esci
                                    break;

                            }//end scelta menu
                            continue;

                        case 2: // SEZIONE TOKEN
                            System.out.println("1. Inserisci un Nuovo Token");
                            System.out.println("2. Ricerca un Token");
                            System.out.println("3. Modifica Dati Token");
                            System.out.println("4. Elimina Token");
                            System.out.println("5. Esci");
                            int sceltaToken =scannerIO.nextInt();
                            switch(sceltaToken){

                                case 1: //inserimento nuovo token
                                    System.out.println("--- Inserimento Token---");
                                    System.out.println("Inserici il nome del Token (Che corrisponderà alla percentuale di sconto): ");
                                    int NomeToken = scannerIO.nextInt();
                                    System.out.println("Inserisci il numero di pasti utili per ottenere il token: ");
                                    int NumPasti = scannerIO.nextInt();
                                    qLessFood.inserisciDatiToken(NomeToken, NumPasti);
                                    System.out.println("Dati inseriti: Nome: Token-"+NomeToken+" Numero Pasti: "+NumPasti);
                                    System.out.println("Confermi? [y/n]");
                                    String conferma = in.readLine();
                                    if(conferma=="y"){
                                        if(qLessFood.confermaDatiToken()==1)
                                            System.out.println("Token inserito con successo nella Lista dei Token di QLessFood.");
                                    }
                                    continue;

                                case 2: //ricerca di un token
                                    System.out.println("--- Ricerca Token---");
                                    System.out.println("Inserici il nome del Token da ricercare: ");
                                    int ricToken = scannerIO.nextInt();
                                    Token tokenSearch = qLessFood.ricercaToken(ricToken);
                                    System.out.println("Token trovato: "+tokenSearch);
                                    continue;


                                case 3: //modifica token
                                    System.out.println("--- Modifica Token---");
                                    System.out.println("Inserici il nome del Token da ricercare: ");
                                    int r = scannerIO.nextInt();
                                    Token tknSearch = qLessFood.ricercaToken(r);
                                    System.out.println("Token trovato: "+tknSearch);
                                    System.out.println("Che modifica vuoi effettuare?");
                                    System.out.println("1. Modifica Nome di un Token");
                                    System.out.println("2. Modifica Numero Pasti di un Token");
                                    System.out.println("3. Modifica Totale (Nome + Num Pasti) di un Token");
                                    int modifica = scannerIO.nextInt();

                                    switch(modifica){
                                        // ore 17.16: modificare le firme dei metodi delle funzioni
                                        case 1:
                                            System.out.println("Modifica Nome di un Token");
                                            System.out.println("Inserisci il nuovo nome del token: ");
                                            nomeTkn = scannerIO.nextInt();
                                            if(qLessFood.modificaNomeToken(tknSearch.getNome(),nomeTkn)==true)
                                                System.out.println("Modifica effettuata con successo.");
                                            continue;
                                        case 2:
                                            System.out.println("Modifica Numero Pasti di un Token");
                                            System.out.println("Inserisci il nuovo numero dei pasti del token: ");
                                             numPastiTkn = scannerIO.nextInt();
                                            if(qLessFood.modificaNumeroPasti(tknSearch.getNome(),numPastiTkn)==true)
                                                System.out.println("Modifica effettuata con successo.");
                                            continue;
                                        case 3:
                                            System.out.println("Modifica tutte le informazioni di un Token");
                                            System.out.println("Inserisci il nuovo nome del token: ");
                                            nomeTkn = scannerIO.nextInt();
                                            System.out.println("Inserisci il nuovo numero dei past del token: ");
                                            numPastiTkn = scannerIO.nextInt();
                                            if(qLessFood.modificaTutto(tknSearch.getNome(),nomeTkn,numPastiTkn)==true)
                                                System.out.println("Modifica effettuata con successo.");
                                            continue;
                                    }

                                    continue;
                                case 4: //eliminazione token
                                    System.out.println("Eliminazione di un Token");
                                    System.out.println("Inserisci il nome del token: ");
                                    nomeTkn = scannerIO.nextInt();
                                    if(qLessFood.eliminaToken(nomeTkn)==true)
                                        System.out.println("Eliminazione avvenuta con successo.");
                                    continue;
                                case 5: //esci sezione token
                                    break;

                            }//end token
                            continue;

                        case 3: // gestione Ordini
                            System.out.println("---Visualizza Ordini---");
                            qLessFood.visualizzaListaOrdini();
                            System.out.println("Ordini da preparare: (Stato: 1)");
                            qLessFood.visualizzaOrdiniInPreparazione();
                            System.out.println("Per confermare l'ordine, premere [y]");
                            String conferma = in.readLine();
                            if(conferma=="y")
                                qLessFood.confermaOrdine(5);
                            System.out.println("Ordine confermato. Verrà generato un QRCode a breve.");
                            continue;
                        case 4: //visualizza Clienti QLessFood
                            System.out.println("--- Visualizza Clienti QLessFood ---");
                            List<Cliente> Users = qLessFood.getListClienti();
                            // sono qui
                            for(Cliente cliente : Users) {
                                System.out.println(cliente.getUsername());
                            }
                            continue;
                        case 5: //Emetti Fattura

                            System.out.println("Scanning QR Code ...");
                            String  usr = "ciao";
                            Fattura f = qLessFood.scanQRCode(5);
                            if(f!=null){
                                System.out.println("Setta come pagato? (premi [y])");
                                String set = in.readLine();
                                if(set=="y"){
                                    qLessFood.setOrdinePagato(5, usr);
                                }
                            }

                            continue;
                        case 6: //Gestione Evento
                            System.out.println("--- Gestione Evento ---");
                            System.out.println("1. Inserisci Nuovo Evento");
                            System.out.println("2. Ricerca Evento");
                            System.out.println("3. Modifica Evento");
                            System.out.println("4. Elimina Evento");
                            System.out.println("5. Esci");
                            int eventScelta = scannerIO.nextInt();
                            switch(eventScelta){
                                case 1: //inserimento evento
                                    System.out.println("--- Inserimento Nuovo Evento ---");
                                    System.out.println("Inserisci nome evento: ");
                                    String nomeEvento = in.readLine();
                                    System.out.println("Inserisci data evento: [dd/MM/yyyy] ");
                                    String newData = in.readLine();
                                    Date dataEvento = new SimpleDateFormat("dd/MM/yyyy").parse(newData);
                                    System.out.println("Inserisci numero di posti disponibili: ");
                                    int numPosti = scannerIO.nextInt();
                                    System.out.println("Inserisci prezzo del biglietto: ");
                                    double prezzoBiglietto = scannerIO.nextDouble();
                                    System.out.println("Inserisci percentuale di sconto con prenotazione su QLessFood: ");
                                    int percSconto = scannerIO.nextInt();
                                    qLessFood.inserisciDatiEvento(nomeEvento, dataEvento, numPosti, prezzoBiglietto,percSconto);
                                    System.out.println("Confermare i dati dell'evento? [y/n]");
                                    conferma = in.readLine();
                                    if(conferma=="y"){
                                        if(qLessFood.confermaDatiEvento()==1){
                                            System.out.println("Dati Evento Confermati");
                                        }
                                    }

                                    continue;
                                case 2: //ricerca evento
                                    System.out.println("--- Ricerca Evento ---");
                                    System.out.println("Inserisci nome dell'Evento da ricercare: ");
                                    String nomeRic = in.readLine();
                                    Evento ricercaEvento = qLessFood.ricercaEvento(nomeRic);
                                    if(ricercaEvento!=null){
                                        System.out.println("Evento trovato: "+ ricercaEvento);
                                    }
                                    continue;
                                case 3: //modifica evento
                                    System.out.println("--- Modifica Evento ---");
                                    System.out.println("Inserisci nome dell'Evento da ricercare: ");
                                    String nome = in.readLine();
                                    Evento ricerca = qLessFood.ricercaEvento(nome);
                                    if(ricerca!=null){
                                        System.out.println("Evento trovato: "+ ricerca);
                                        System.out.println("Inserisci nome evento: ");
                                        String newnomeEvento = in.readLine();
                                        System.out.println("Inserisci data evento: [dd/MM/yyyy] ");
                                        String newdataEv = in.readLine();
                                        Date newdataEvento = new SimpleDateFormat("dd/MM/yyyy").parse(newdataEv);
                                        System.out.println("Inserisci numero di posti disponibili: ");
                                        int newnumPosti = scannerIO.nextInt();
                                        System.out.println("Inserisci prezzo del biglietto: ");
                                        double newprezzoBiglietto = scannerIO.nextDouble();
                                        System.out.println("Inserisci percentuale di sconto con prenotazione su QLessFood: ");
                                        int newpercSconto = scannerIO.nextInt();
                                        qLessFood.inserisciDatiEvento(newnomeEvento, newdataEvento, newnumPosti, newprezzoBiglietto,newpercSconto);
                                        System.out.println("Confermare i nuovi dati dell'evento? [y/n]");
                                        conferma = in.readLine();
                                        if(conferma=="y"){
                                            if(qLessFood.confermaDatiEvento()==1){
                                                qLessFood.confermaEliminaEvento(nome);
                                                System.out.println("Dati Evento Modificati");
                                            }
                                        }
                                    }

                                    continue;
                                case 4: //elimina evento
                                    System.out.println("--- Eliminazione Evento");
                                    System.out.println("Inserisci nome Evento da eliminare: ");
                                    String eventoElim = in.readLine();
                                    Evento eventoEliminare = qLessFood.ricercaEvento(eventoElim);
                                    if(eventoEliminare!=null){
                                        System.out.println("Evento trovato. Eliminare? [y/n]");
                                        String con = in.readLine();
                                        if(con=="y"){
                                            qLessFood.confermaEliminaEvento(eventoElim);
                                        }

                                    }
                                    continue;
                                case 5: // esci evento
                                    break;
                            }//end eventScelta

                            continue;
                        case 7: // USCITA PORTALE ADMIN
                            break; // esco dalla gestione dell'admin
                    }
                    break;

                case 2:
                    System.out.println("Area Clienti");
                    System.out.println("1. Login");
                    System.out.println("2. Register");
                    System.out.println("3. Esci");

                    int reglog = scannerIO.nextInt(); //register or login


                    switch (reglog) {

                        case 1: // Login
                            System.out.println("--- Login ---");
                            System.out.println("Inserisci username: ");
                            String username = in.readLine();
                            System.out.println("Inserisci password: ");
                            String password = in.readLine();
                            c = qLessFood.ricercaCliente(username);

                            if (c != null) {
                                System.out.println("**** AREA CLIENTI ****** ");
                                System.out.println("1. Prenotazione di un Pasto da Effettì Mense");
                                System.out.println("2. Prenotazione di un Evento");
                                int clientScelta = scannerIO.nextInt();
                                switch(clientScelta) {

                                    case 1: //prenotazione Pasto
                                        System.out.println("Inserisci Data del pasto: ");
                                        data = in.readLine();
                                        date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                                        System.out.println("Inserisci tipologia pasto: [0: PRANZO | 1: CENA]");
                                        int ti = scannerIO.nextInt();
                                        MenuPasto m = qLessFood.ricercaMenu(date, ti);
                                        listPortate = m.getListPortate();
                                        System.out.println("Menu Trovato: ");
                                        for(Portata p : listPortate) {
                                            System.out.println("ID: "+p.getIdPortata()+" Descrizione: "+p.getDescrizione());
                                        }



                                        for (int i = 0; i < 6; i++) {
                                            System.out.println("Inserisci id portata: ");
                                            int id = scannerIO.nextInt();
                                            // qui deve continuare
                                            qLessFood.selezionaPortata(id, date, ti);
                                            // continua
                                        }

                                        // seleziona fascia oraria
                                        System.out.println("Seleziona fascia oraria: ");
                                        data = in.readLine();
                                        Date fascia = new SimpleDateFormat("dd/MM/yyyy").parse(data);

                                        //tipo pagamento
                                        System.out.println("Seleziona metodo di pagamento [0: ALLA CASSA | 1: ONLINE]");
                                        int metodo = scannerIO.nextInt();
                                        if (metodo == 1) { // pagamento con carta
                                            System.out.println("--- Inserimento Dati Carta --- ");
                                            System.out.println("Inserisci Numero Carta: ");
                                            String NumCarta = in.readLine();
                                            System.out.println("Inserisci Nome Intestatario: ");
                                            String nome = in.readLine();
                                            System.out.println("Inserisci Cognome Intestatario");
                                            String cognome = in.readLine();
                                            System.out.println("Inserisci CVV");
                                            int CVV = scannerIO.nextInt();
                                            System.out.println("Data scadenza: [MM/AA]");
                                            String dataScadenza = in.readLine();

                                            qLessFood.inserisciDatiCarta(NumCarta, nome, cognome, CVV, dataScadenza);

                                            System.out.println(" Verifica in Corso ... ");
                                            TimeUnit.SECONDS.sleep(2);
                                            System.out.println("Pagamento effettuato con successo.");


                                        }

                                        qLessFood.nuovoOrdine(date, ti);
                                        int sconto = qLessFood.getUserToken(username);

                                        if (sconto != 0) {
                                            System.out.println("Gentile " + username + "Hai il Token-" + sconto);
                                            System.out.println("Vuoi utilizzarlo? [y/n]");
                                            String risp = in.readLine();
                                            if (risp == "y") {
                                                qLessFood.utilizzaToken(sconto, 5);
                                                qLessFood.confermaUtilizzoToken(username);
                                            }
                                        }
                                        qLessFood.confermaDatiNuovoOrdine();
                                        continue;
                                    case 2: // prenotazione evento
                                        System.out.println("--- Prenotazione Evento --- ");
                                        System.out.println("Inserisci il Nome dell'Evento da ricercare: ");
                                        String ricerca = in.readLine();
                                        Evento ricercaE = qLessFood.ricercaEvento(ricerca);
                                        if(ricercaE!=null){
                                            System.out.println("Evento trovato: ");
                                            System.out.println("Nome: "+ricercaE.getNome());
                                            System.out.println("Data: "+ricercaE.getData());
                                            System.out.println("Posti disponibili: "+ricercaE.getPostiTotali());
                                            System.out.println("Prezzo:"+ricercaE.getPrezzo());
                                            System.out.println("Sconto se prenoti con QLessFood:"+ricercaE.getSconto());
                                            System.out.println("Quanti posti vuoi prenotare?");
                                            int postiRichiesti = scannerIO.nextInt();
                                            qLessFood.inserisciPostiPrenotazione(postiRichiesti, ricercaE.getNome(), username);
                                            double totale = (ricercaE.getPrezzo() - (ricercaE.getPrezzo() * ricercaE.getSconto())/100)*postiRichiesti;
                                            System.out.println("Riepilogo | Nome Evento: "+ ricercaE.getNome() + "Data: "+ricercaE.getData()+"Costo totale: "+totale);
                                            System.out.println("Confermare? [y/n]");
                                            String confermaEvento = in.readLine();
                                            if(confermaEvento=="y"){
                                                if(qLessFood.confermaDatiPrenotazione()==1){
                                                    System.out.println("Prenotazione all'Evento confermata.");
                                                }

                                            }

                                        }
                                        continue;

                                }

                            continue;

                            }

                        case 2: // Register
                            System.out.println("--- Registrazione Cliente ---");
                            System.out.println("Inserisci username: ");
                            String u = in.readLine();
                            System.out.println("Inserisci email: ");
                            String email = in.readLine();
                            System.out.println("Inserisci password: ");
                            String pwd = in.readLine();


                            qLessFood.inserisciDatiCliente(u,email,pwd);

                            if (qLessFood.confermaDatiCliente()== 1) {
                                System.out.println("Registrazione effettuata con successo.\nEffettuare login per accedere a QLessFood.");
                            }
                            continue;


                        case 3:
                            break;

                    }

                case 3:
                    System.exit(0);
                    break;
            }
        }

    } //end main




} //end class



