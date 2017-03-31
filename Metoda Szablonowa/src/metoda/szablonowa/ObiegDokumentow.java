package metoda.szablonowa;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author grzesiek
 */
public abstract class ObiegDokumentow {
    
    ArrayList<Dokument> dokumenty;
    
    public ObiegDokumentow(){
        dokumenty = new ArrayList<>();
    }
    
    public void przyjecieDokumentu(String rodzaj, String nadawca){
        
        // wstepne utworzenie dokumentu
        Dokument dok = new Dokument();
        dok.data = new Date();
        dok.rodzaj = rodzaj;
        dok.nadawca = nadawca;
        dok.status = "";
        dokumenty.add(dok);
        
        // obieg doumentu
        skierowanieDokumentu(dok);
        rozpatrzenieDokumentu(dok);
        podpisDokumentu(dok);
        zwrotDokumentu(dok);
        
    };
    
    protected void skierowanieDokumentu(Dokument dok){    
    }
    
    protected void rozpatrzenieDokumentu(Dokument dok){
    }
    
    protected void podpisDokumentu(Dokument dok){
        dok.podpis = dok.pracownik;
        dok.status += "Podpisano.\n";
    }
    
    protected void zwrotDokumentu(Dokument dok){
        if ( !dok.podpis.isEmpty() ){
            dok.status += "Zwrot do nadawcy.\n";
        }
    }

}
