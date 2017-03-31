package pl.delapiero.ztp;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import javax.swing.JTextArea;

/**
 *
 * @author grzesiek
 */
public class Pula implements Runnable {
    
    private Serwer[] watek = new Serwer[1];
    private LinkedList<Socket> kolejka;
    private Serwer straznik;
    private JTextArea konsola;
    
    public Pula(JTextArea _konsola){
        konsola = _konsola;
        kolejka = new LinkedList<>();
        
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
            ServerSocket gniazdoSerwera = new ServerSocket(4444);
            Kolejka k = new Kolejka (konsola, watek, kolejka);
            new Thread(k).start();
            
            komunikat("Start serwera.");
            while (true) {
                Socket polaczenie = gniazdoSerwera.accept();
                boolean wolnySlot = false;
                
                for(int i=0; i<watek.length; ++i){
                    synchronized(this) {
                        konsola.append( Integer.toString(i)+ ":" + (watek[i].isAlive()?"zajety":"wolny") + "\n");
                        if ( watek[i].czyPolaczony() == false ){
                            watek[i].interrupt();
                            watek[i] = new Serwer(konsola);
                            watek[i].ustawPolaczenie( polaczenie );
                            watek[i].start();
                            wolnySlot = true;
                            break;
                        }
                    }
                }
                synchronized(this) {
                    try {
                        this.wait(100);
                    } catch (InterruptedException ex) {
                        komunikat("InterruptedException\n");
                    }
                }
                // wyslanie komunikatu
                if ( wolnySlot == false ) {
                    kolejka.addLast(polaczenie);
                    komunikat("Klient dodany do kolejki.");
                    komunikat("Klientow w kolejce:" + kolejka.size());
                }
            }
        } catch (IOException ex) {
            komunikat("IOException");
        }
    }
    
}
