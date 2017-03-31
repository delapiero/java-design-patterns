package pl.delapiero.ztp;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 *
 * @author grzesiek
 */
public class Pula implements Runnable {
    
    private Serwer[] watek = new Serwer[1];
    private Serwer straznik;
    private JTextArea konsola;
    private int port;
    
    public Pula(JTextArea _konsola, int _port){
        konsola = _konsola;
        port = _port;
        
        for(int i=0; i<watek.length; ++i){   
            watek[i] = new Serwer(konsola);
        }
    }
    
    public void komunikat(String wiadomosc){
        System.out.println(wiadomosc);
        konsola.append(wiadomosc + "\n");    
    }

    @Override
    public void run() {
        try {
            ServerSocket gniazdoSerwera = new ServerSocket(port);
            komunikat("Start serwera.");
            while (true) {
                Socket polaczenie = gniazdoSerwera.accept();
                boolean wolnySlot = false;
                
                for(int i=0; i<watek.length; ++i){
                    komunikat( Integer.toString(i)+ ":" + (watek[i].isAlive()?"zajety":"wolny"));
                    if ( watek[i].czyPolaczony() == false ){
                        watek[i].interrupt();
                        watek[i] = new Serwer(konsola);
                        watek[i].ustawPolaczenie( polaczenie );
                        watek[i].start();
                        wolnySlot = true;
                        break;
                    }
                }
                // wyslanie komunikatu
                if ( wolnySlot == false ) {
                    straznik = new Serwer(konsola);
                    straznik.ustawPolaczenie( polaczenie );
                    straznik.odrzuc();
                    komunikat("Odrzucono połączenie.");
                }
            }
        } catch (IOException ex) {
            komunikat("IOException");
        }
    }
    
}
