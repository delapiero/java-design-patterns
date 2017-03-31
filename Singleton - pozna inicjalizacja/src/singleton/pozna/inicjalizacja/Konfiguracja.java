package singleton.pozna.inicjalizacja;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author grzesiek
 */

public class Konfiguracja {
    
        private static Konfiguracja instance = null;
        public int id = 0;
        
        //ustawienia
        public String login;
        public String haslo;
        public boolean zapamietaj;
    
        private String plik = "config.txt";
 
        private Konfiguracja() {
            Random r = new Random();
            id = r.nextInt()+1;
        }
        
        public static Konfiguracja getInstance() {
            if (instance != null) {
                return instance;
            }
            synchronized (Konfiguracja.class){
                if (instance == null) {
                    instance = new Konfiguracja ();
                }
            }             
            return instance;
        }
        
        public void zapis(){
        PrintWriter zapis = null;
        try {
            zapis = new PrintWriter(plik);
            zapis.println(login);
            zapis.println(haslo);
            zapis.println(Boolean.toString(zapamietaj));
        } catch (FileNotFoundException ex) {

        } finally {
            zapis.close();
        }
    }
    
    public void odczyt(){
        try {
            File file = new File(plik);
            Scanner in = new Scanner(file);
            login = in.nextLine();
            haslo = in.nextLine();
            zapamietaj = Boolean.parseBoolean(in.nextLine());
        } catch (FileNotFoundException ex) {
        }
    }
}