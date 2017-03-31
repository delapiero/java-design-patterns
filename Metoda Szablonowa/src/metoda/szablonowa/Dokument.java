package metoda.szablonowa;

import java.util.Date;

/**
 *
 * @author grzesiek
 */
public class Dokument {
    public String rodzaj;
    public String nadawca;
    public Date data;
    
    public String status;
    
    public Dzial dzial;
    public String pracownik;
    public String podpis;
    
    public void drukuj(){
        System.out.println(rodzaj);
        System.out.println(nadawca);
        System.out.println(data.toString());
        System.out.println(status);
        System.out.println(podpis);
    }
}
