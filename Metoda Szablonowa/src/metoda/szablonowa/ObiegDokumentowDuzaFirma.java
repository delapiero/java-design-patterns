package metoda.szablonowa;

import java.util.Random;

/**
 *
 * @author grzesiek
 */
public class ObiegDokumentowDuzaFirma extends ObiegDokumentow{
    
    public Dzial umowy;
    public Dzial reklamacje;
    
    public ObiegDokumentowDuzaFirma(){
    }
    
    @Override
    protected void skierowanieDokumentu(Dokument dok){
        if ( dok.rodzaj.equalsIgnoreCase("Umowa") || dok.rodzaj.equalsIgnoreCase("Rozwiązanie umowy")){
            dok.pracownik = umowy.kierownik;
            dok.dzial = umowy;
            dok.status += "Skierowano do działu umów.\n";
        } else if ( dok.rodzaj.equalsIgnoreCase("Reklamacja")){
            dok.pracownik = reklamacje.kierownik;
            dok.dzial = reklamacje;
            dok.status += "Skierowano do działu reklamacji.\n";
        }
    }
    
    @Override
    protected void rozpatrzenieDokumentu(Dokument dok){
        
        dok.pracownik = dok.dzial.przydzielPracownika();
        if ( dok.rodzaj.equalsIgnoreCase("Umowa")){
            dok.status += "Do podpisu.\n";
            
        } else if ( dok.rodzaj.equalsIgnoreCase("Rozwiązanie umowy")){
            Random r = new Random();
            dok.status = "Pozostała należność: " + r.nextInt(500) + ".\n";
            
        } else if ( dok.rodzaj.equalsIgnoreCase("Reklamacja")){
            Random r = new Random();
            dok.status = "Rozpatrzono " + (r.nextBoolean() ? "pozytywnie" : "negatywnie") + ".\n";
        }
    }
    
    @Override
    protected void podpisDokumentu(Dokument dok){   
        dok.podpis = dok.dzial.kierownik;
        dok.status += "Podpisano.\n";
    }
    
    @Override
    protected void zwrotDokumentu(Dokument dok){
        dok.status += "Skierowano do zwrotu.\n";
        super.zwrotDokumentu(dok);
    }  
    
}
