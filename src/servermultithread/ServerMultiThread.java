package servermultithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerMultiThread {

    public static void main(String[] args) {
        int risultato = 0;
        int richiesta = 0;
        String r;
        
        try {
            ServerSocket server = new ServerSocket(5500);
            System.out.println("Server è attivo e in ascolto");
            Socket client = server.accept();
            System.out.println("Connessione ricevuta");

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            r = in.readLine();
            
            while (richiesta>0) {
                Thread Serverino = new Thread(new ServerThread(risultato, richiesta));
                Serverino.start();

                richiesta--;
            }

            System.out.println("Il risultato è: "+risultato);
        } catch (IOException ex) {
            Logger.getLogger(ServerMultiThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized void somma() {
        
    }
}
