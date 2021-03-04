package servermultithread;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerThread implements Runnable {
    private int n;
    private int risultato;
    private boolean controllo = true;

    public ServerThread(int risultato, int n) {
        this.n = n;
        this.risultato = risultato;
    }

    @Override
    public void run() {
        while (controllo) {
            System.out.println(n);
            termina();
        }
    }
    
    public void termina() {
        controllo = false;
    }
}
