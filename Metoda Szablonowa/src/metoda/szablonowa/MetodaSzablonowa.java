package metoda.szablonowa;

/**
 *
 * @author grzesiek
 */
public class MetodaSzablonowa {

    public static void main(String[] args) {
        
        // mała firma
        System.out.println("Mała firma:");
        ObiegDokumentowMalaFirma firma1 = new ObiegDokumentowMalaFirma("Jan Kowalski","Firma1");
        firma1.przyjecieDokumentu("Umowa", "Marcin Nowak");
        Dokument dok1 = firma1.dokumenty.get(0);
        dok1.drukuj();
        
        System.out.println();
        
        // duza firma
        System.out.println("Duża firma:");
        ObiegDokumentowDuzaFirma firma2 = new ObiegDokumentowDuzaFirma();
        // dział umow
        firma2.umowy = new Dzial();
        firma2.umowy.kierownik = "Tomasz Rak";
        firma2.umowy.pracownicy.add("Joanna");
        firma2.umowy.pracownicy.add("Jadwiga");
        // dzial reklamacji
        firma2.reklamacje = new Dzial();
        firma2.reklamacje.kierownik = "Remigiusz Rak";
        firma2.reklamacje.pracownicy.add("Irena");
        firma2.reklamacje.pracownicy.add("Piotr");
        // przyjecie dokumentu
        firma2.przyjecieDokumentu("Rozwiązanie umowy", "Marcin Nowak");
        Dokument dok2 = firma2.dokumenty.get(0);
        dok2.drukuj();
    }
}
