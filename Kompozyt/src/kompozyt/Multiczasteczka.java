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
public class Multiczasteczka extends ObiektWieloczasteczkowy {
    
    ArrayList<ObiektWieloczasteczkowy> czasteczka;
    
    public Multiczasteczka(){
        czasteczka = new ArrayList<>();
    }

    @Override
    public void przesuniecie(Wektor3d _v) {
        for(ObiektWieloczasteczkowy o : czasteczka){
            o.przesuniecie(_v);
        }
    }

    @Override
    public double podajMase() {
        double sumaMasy = 0;
        for(ObiektWieloczasteczkowy o : czasteczka){
            sumaMasy += o.podajMase();
        }
        return sumaMasy;
    }
    
    @Override
    public int podajZlozonosc() {
        int zlozonosc = 0;
        for(ObiektWieloczasteczkowy o : czasteczka){
            zlozonosc += o.podajZlozonosc();
        }
        return zlozonosc;
    }
    
    @Override
    public Wektor3d srodekMasy() {
        Wektor3d _v = new Wektor3d(0,0,0);
        double sumaMasy = 0;
        for(ObiektWieloczasteczkowy o : czasteczka){
            Wektor3d c = o.srodekMasy();
            _v.x += c.x * o.podajMase();
            _v.y += c.y * o.podajMase();
            _v.z += c.z * o.podajMase();
            sumaMasy += o.podajMase();
        }
        _v.x /= sumaMasy;
        _v.y /= sumaMasy;
        _v.z /= sumaMasy;
        return _v;
    }

    @Override
    public Wektor3d srodekGeometryczny() {
        Wektor3d _v = new Wektor3d(0,0,0);
        int iloscCzastek = 0;
        for(ObiektWieloczasteczkowy o : czasteczka){
            Wektor3d c = o.srodekGeometryczny();
            iloscCzastek += o.podajZlozonosc();
            _v.x += c.x;
            _v.y += c.y;
            _v.z += c.z;
        }
        _v.x /= iloscCzastek;
        _v.y /= iloscCzastek;
        _v.z /= iloscCzastek;
        return _v;
    }
    
    public void dodaj(ObiektWieloczasteczkowy o){
        czasteczka.add(o);
    }
    
    public void usun(ObiektWieloczasteczkowy o){
        czasteczka.remove(o);
    }
    
    @Override
    public String toString(){
        String wynik = "";
        for(ObiektWieloczasteczkowy o : czasteczka){
            wynik += o.toString();
        }
        return wynik;
    }
}
