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
public class Centrala {
    private ArrayList<Telefon> abonenci;
    
    public Centrala(){
        abonenci = new ArrayList<>();
    }
    
    private String nowyNumer(){
        int numer = 1;
        boolean wolnyNumer = false;
        
        while( wolnyNumer == false ){
            for(Telefon abonent : abonenci){
                if( Integer.toString(numer) == abonent.pobierzNumer() ){
                    ++numer;
                    break;
                }
                wolnyNumer = true;
            }
        }
        
        return Integer.toString(numer);
    }
    
    public String rejestracja(Telefon telefon){
        abonenci.add(telefon);
        return nowyNumer();
    }
    
    public void odbierzSMS(SMS sms){
        for(Telefon abonent : abonenci){
            if( abonent.pobierzNumer().equals(sms.odbiorca) ){
                abonent.odbierzSMS(sms);
            }
        }
    }
}
