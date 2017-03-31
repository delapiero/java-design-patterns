package metoda.szablonowa;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author grzesiek
 */
public class Dzial {
    public String nazwa;
    public String kierownik;
    public ArrayList<String> pracownicy;
    
    public Dzial(){
        pracownicy = new ArrayList<>();
    }
    
    public String przydzielPracownika(){
        String pracownik;
        if(pracownicy.isEmpty()){
            pracownik = kierownik;
        } else {
            Random r = new Random();
            int nr = r.nextInt(pracownicy.size()-1);
            pracownik = pracownicy.get(nr);
        }
        return pracownik;
    }
}
