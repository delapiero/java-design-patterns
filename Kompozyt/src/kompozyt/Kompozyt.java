/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kompozyt;

import java.util.ArrayList;

/**
 *
 * @author grzesiek
 */
public class Kompozyt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // czasteczki
        System.out.print("Czasteczki proste:\n");
        ObiektWieloczasteczkowy c1 = new Czasteczka(new Wektor3d(1,1,1), 1);
        ObiektWieloczasteczkowy c2 = new Czasteczka(new Wektor3d(2,2,2), 1);
        System.out.print(c1.toString());
        System.out.print(c2.toString());
        
        // multiczasteczki
        System.out.print("Multiczasteczki:\n");
        ObiektWieloczasteczkowy m1 = new Czasteczka(new Wektor3d(0,0,0), 2);
        ObiektWieloczasteczkowy m2 = new Czasteczka(new Wektor3d(0,2,0), 1);
        ObiektWieloczasteczkowy m3 = new Czasteczka(new Wektor3d(2,0,0), 1);
        ObiektWieloczasteczkowy m4 = new Czasteczka(new Wektor3d(2,2,0), 1);
        ObiektWieloczasteczkowy m5 = new Czasteczka(new Wektor3d(3,3,0), 1);
        
        Multiczasteczka M1 = new Multiczasteczka();
        M1.dodaj(m1);
        M1.dodaj(m2);
        M1.dodaj(m3);
        Multiczasteczka M2 = new Multiczasteczka();
        M2.dodaj(m4);
        M2.dodaj(m5);
        M2.dodaj(M1);
        System.out.print(M1.srodekGeometryczny());
        System.out.print(M1.srodekMasy());
        
        //obiekt wieloczasteczkowy
        System.out.print("Obiekty wieloczasteczkowe:\n");
        ArrayList<ObiektWieloczasteczkowy> tab = new ArrayList<>();
        tab.add(c1);
        tab.add(c1);
        tab.add(M2);
        
        for(int i=0; i<tab.size(); ++i){
            System.out.print("tab " + i + ":\n");
            tab.get(0).przesuniecie(new Wektor3d(1,1,1));  
            System.out.print(tab.get(i));
        }
    }
}
