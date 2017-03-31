package pl.delapiero.ztp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JTextArea;

/**
 *
 * @author grzesiek
 */
public class Klient extends Thread {
    
    public Socket polaczenie = null;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private String serwer;
    
    private JTextArea konsola;
    private String IP;
    private int port;        
    
    public Klient(JTextArea _konsola){
        konsola = _konsola; 
    }
    
    public void ustawSerwer(String _IP, int _port){
        IP = _IP;
        port = _port;
    }
    
    @Override
    public void run(){
        try {
            polaczenie = new Socket(IP,port);
            System.out.println("Polaczono z " + IP + ":" + Integer.toString(port));
            
            out = new ObjectOutputStream(polaczenie.getOutputStream());
            in = new ObjectInputStream(polaczenie.getInputStream());
            out.flush();
            
            try {
                serwer = (String)in.readObject();
                komunikat("server> " + serwer);
            } catch (ClassNotFoundException ex) {
                komunikat("wyjatek ClassNotFoundException");
            } catch (UnknownHostException ex) {
                komunikat("wyjatek UnknownHostException");
            }
            
            
        } catch (IOException ex) {
            komunikat("wyjatek IOException");
        }
    }
    
    public void wyslij(String wiadomosc){
        try {
            out.writeObject(wiadomosc);
            out.flush();
            komunikat("klient> " + wiadomosc);
            
            serwer = (String)in.readObject();
            komunikat("server> " + serwer);
        } catch (IOException ex) {
            komunikat("wyjatek IOException");
        } catch (ClassNotFoundException ex) {
            komunikat("wyjatek ClassNotFoundException");
        }
    }
        
    public void komunikat(String wiadomosc){
        System.out.println(wiadomosc);
        konsola.append(wiadomosc + "\n");    
    }
    
}
