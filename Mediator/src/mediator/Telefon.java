/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mediator;

import java.util.ArrayList;

/**
 *
 * @author grzesiek
 */

public class Telefon {
    private Centrala centrala;
    private String numer;
    private ArrayList<SMS> skrzynka;
    
    public Telefon(){
        skrzynka = new ArrayList<>();
    }
    
    public String pobierzNumer(){
        return numer;
    }
    
    public void rejestracja(Centrala _centrala){
        centrala = _centrala;
        numer = centrala.rejestracja(this);
    }
    
    public void wyslijSMS(String odbiorca, String tresc){
        centrala.odbierzSMS(new SMS(numer, odbiorca, tresc) );
    }
    
    public void odbierzSMS(SMS sms){
        skrzynka.add(sms);
    }
    
    public void odebrane(){
        for(SMS sms : skrzynka){
            System.out.print(sms.odbiorca + ":\n" + sms.tresc + "\n");
        }
    }
}
