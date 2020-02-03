import classes.Cliente;
import classes.QLessFood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class QLFApplication {

    private static QLessFood qLessFood;


    public static void main(String[] args) throws IOException {

        qLessFood = qLessFood.getInstance();

        Cliente c = new Cliente();
        boolean a = true;

        while (a==true) {
            System.out.println("QLessFood --- Effettì Mense ©2020");
            System.out.println("ACCEDI . . . ");
            System.out.println("1. Admin access");
            System.out.println("2. Client access");
            System.out.println("3. Esci");

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            Scanner scannerIO = new Scanner(System.in);

            int mode = scannerIO.nextInt();

            switch (mode) {

                case 1:
                    System.out.println("Admin mode");
                    break;

                case 2:
                    System.out.println("Client mode");
                    System.out.println("1. Login");
                    System.out.println("2. Register");

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
                                System.out.println("Bella lui!");
                            }
                            break;

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

                            break;



                    }

                    case 3:
                        a = false;
                        break;
            }

        }
    }

}



