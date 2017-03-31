package pl.delapiero.ztp;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author grzesiek
 */
public class Serwer extends Thread {
    
        private Socket polaczenie = null;
        private ObjectOutputStream out;
        private ObjectInputStream in;
        private String klient;
        
        private JTextArea konsola;
        
        public Serwer(JTextArea _konsola){ 
            konsola = _konsola;            
        }
        
        public void ustawPolaczenie(Socket _polaczenie){
            polaczenie = _polaczenie;
        }
        
        public boolean czyPolaczony(){
            if ( this.isAlive() ){
                return true;
            } else {
                return false;
            }
        }
        
        @Override
        public void run(){
            try {
                
                out = new ObjectOutputStream(polaczenie.getOutputStream());
		in = new ObjectInputStream(polaczenie.getInputStream());
                out.flush();
                
                wyslij("Połączono.");
                
                do {
                    try {
                        klient = (String)in.readObject();
                        komunikat("klient> " + klient);
                        wyslij( Integer.toString(klient.length()) );
                    } catch (ClassNotFoundException ex) {
                        komunikat("wyjatek ClassNotFoundException");
                    }
                } while ( klient != "exit" && polaczenie.isConnected() );
                
                komunikat("Koniec połączenia.");
                
            } catch (IOException ex) {
            } finally {
                    try {
                        in.close();
                        out.close();
                    } catch (IOException ex) {
                        komunikat("wyjatek IOException");
                    }
		}
        }
        
        public void wyslij(String wiadomosc){
            try {
                out.writeObject(wiadomosc);
                out.flush();
                komunikat("serwer> " + wiadomosc);
            } catch (IOException ex) {
                komunikat("wyjatek IOException");
            }
        }
        
        public void komunikat(String wiadomosc){
            System.out.println(wiadomosc);
            konsola.append(wiadomosc + "\n");    
        }
        
        public void odrzuc(){
            try {
                out = new ObjectOutputStream(polaczenie.getOutputStream());
                wyslij("Serwer pełny.");
                out.close();       
            } catch (IOException ex) {
                komunikat("wyjatek IOException");
            }
        }
}
