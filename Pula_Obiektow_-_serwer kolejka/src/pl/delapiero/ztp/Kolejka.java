package pl.delapiero.ztp;

import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author grzesiek
 */
public class Kolejka implements Runnable {
    
    private JTextArea konsola;
    private Serwer[] watek;
    private LinkedList<Socket> kolejka = new LinkedList<>();
    
    public Kolejka( JTextArea _konsola, Serwer[] _watek, LinkedList _kolejka ){
        konsola = _konsola;
        watek = _watek;
        kolejka = _kolejka;
    }
    
    public void komunikat(String wiadomosc){
        System.out.println(wiadomosc);
        konsola.append(wiadomosc + "\n");    
    }

    @Override
    public void run() {
        komunikat("Start kolejki.");
        while(true){
            synchronized(this) {
            if(kolejka.isEmpty() == false){
                for(int i=0; i<watek.length; ++i){
                        if ( watek[i].czyPolaczony() == false ){
                            watek[i].interrupt();
                            watek[i] = new Serwer(konsola);
                            watek[i].ustawPolaczenie( kolejka.poll() );
                            watek[i].start();
                            komunikat("Klient usuniety z kolejki.");
                            komunikat("Klientow w kolejce:" + kolejka.size());
                            break;
                    }
                }
            }
                try {
                    this.wait(100);
                } catch (InterruptedException ex) {
                    komunikat("InterruptedException");
                }
            }
        }
    }
    
}
