import classes.Cliente;
import classes.MenuPasto;
import classes.Portata;
import classes.QLessFood;

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

        qLessFood = qLessFood.getInstance();

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

        boolean mainloop=true;
        while(mainloop==true) {

            System.out.println("QLessFood --- Effettì Mense 2020");
            System.out.println("ACCEDI . . . ");
            System.out.println("1. Admin access");
            System.out.println("2. Client access");
            System.out.println("3. Esci");

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            Scanner scannerIO = new Scanner(System.in);

            int mode = scannerIO.nextInt(); //mode può essere o admin o client

            switch (mode) {

                case 1: //portale admin

                    boolean adminloop = true;
                    while (adminloop == true) {


                        System.out.println("QLessFood - Portale Admin");
                        System.out.println("1. Gestione dei Menu");
                        System.out.println("2. Gestione dei Token-Sconto");
                        System.out.println("3. Esci");

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
                                        System.out.println("Menu Trovato: " + ricercaMenu);

                                        continue;

                                    case 3: // modifica

                                        System.out.println("--- Modifica Menu Pasto ---");
                                        System.out.println("Inserisci Tipologia del Pasto da ricercare[0: PRANZO | 1: CENA]");
                                        int tipos = scannerIO.nextInt();
                                        System.out.println("Inserisci Data del Pasto da ricercare: [dd/MM/yyyy]");
                                        data = in.readLine();
                                        date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                                        MenuPasto ricercaMod = qLessFood.ricercaMenu(date, tipos);
                                        System.out.println("Cosa vuoi modificare?");
                                        System.out.println("1. Dati del Menu");
                                        System.out.println("2. Dati delle portate del Menu");
                                        String m = in.readLine();

                                        if (m == "1") { //modifico i dati del menu
                                            //new Data, new Tipologia, new Prezzo
                                            System.out.println("Inserisci nuova tipologia [0:PRANZO | 1: CENA]");
                                            int newTipologia = scannerIO.nextInt();
                                            System.out.println("Inserisci nuova Data:[dd/MM/yyyy]");
                                            String newData = in.readLine();
                                            Date newDate = new SimpleDateFormat("dd/MM/yyyy").parse(newData);
                                            System.out.println("Inserisci nuovo Prezzo: ");
                                            double newPrezzo = scannerIO.nextDouble();
                                            qLessFood.modificaMenu(ricercaMod, newDate, newTipologia, newPrezzo);

                                        } else if (m == "2") {//modifico i dati delle portate
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


                                    case 5: //esci
                                        continue;

                                }//end scelta menu


                            case 2: // SEZIONE TOKEN
                                System.out.println("1. Inserisci un Nuovo Token");
                                System.out.println("2. Ricerca un Token");
                                continue;


                            case 3: // USCITA PORTALE ADMIN
                                adminloop = false;
                                break; // esco dalla gestione dell'admin
                        }

                    } //loop gestionale admin


                case 2:

                    // Sezione Clienti
                    boolean clientloop = true;
                    while (clientloop == true) {
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
                                    System.out.println("Prenotazione di un Pasto da Effettì Mense");
                                    System.out.println("Inserisci Data del pasto: ");
                                    data = in.readLine();
                                    date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                                    System.out.println("Inserisci tipologia pasto: [0: PRANZO | 1: CENA]");
                                    int ti = scannerIO.nextInt();
                                    MenuPasto m = qLessFood.ricercaMenu(date, ti);
                                    ArrayList<Portata> listportate = (ArrayList<Portata>) m.getListPortate();
                                    System.out.println("Queste sono le portate del Menu: " + listportate);


                                    for (int i = 0; i < 6; i++) {
                                        System.out.println("Inserisci id portata: ");
                                        int id = scannerIO.nextInt();
                                        // qui deve continuare
                                        qLessFood.selezionaPortata(id);
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

                                }
                                continue;

                            case 2: // Register
                                System.out.println("Inserisci username: ");
                                String u = in.readLine();
                                System.out.println("Inserisci email: ");
                                String email = in.readLine();
                                System.out.println("Inserisci password: ");
                                String pwd = in.readLine();

                                Cliente newCliente = new Cliente(u, email, pwd);


                                if (qLessFood.confermaDatiCliente(newCliente) == 1) {
                                    System.out.println("Registrazione effettuata con successo.\nEffettuare login per accedere a QLessFood.");
                                }
                                continue;


                            case 3:
                                clientloop=false;
                                break;

                        }


                    }
                case 3:
                    mainloop = false;
                    //System.exit(0);
                    break;
            }
        }

    } //end main




} //end class



