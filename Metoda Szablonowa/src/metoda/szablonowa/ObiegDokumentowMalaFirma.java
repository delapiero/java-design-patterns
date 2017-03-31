package metoda.szablonowa;

import java.util.Random;

/**
 *
 * @author grzesiek
 */
public class ObiegDokumentowMalaFirma extends ObiegDokumentow {
    
    Dzial firma;
    
    public ObiegDokumentowMalaFirma(String _wlasciciel, String _nazwaFirmy){
        firma = new Dzial();
        firma.kierownik = _wlasciciel;
        firma.nazwa = _nazwaFirmy;
    }
    
    @Override
    protected void skierowanieDokumentu(Dokument dok){
        dok.pracownik = firma.kierownik;
        dok.dzial = firma;
    }
    
    @Override
    protected void rozpatrzenieDokumentu(Dokument dok){
        if ( dok.rodzaj.equalsIgnoreCase("Umowa")){
            dok.status = "Do podpisu.\n";
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
        super.podpisDokumentu(dok);
    }
    
    @Override
    protected void zwrotDokumentu(Dokument dok){
        super.zwrotDokumentu(dok);
    }  
}
