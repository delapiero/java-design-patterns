/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mediator;

import java.io.IOException;

/**
 *
 * @author grzesiek
 */
public class Mediator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Centrala centrala = new Centrala();
        Smartfon tomek = new Smartfon();
        Tablet wojtek = new Tablet();
        
        tomek.rejestracja(centrala);
        wojtek.rejestracja(centrala);
        
        tomek.Internet();
        wojtek.film();
        
        tomek.wyslijSMS(wojtek.pobierzNumer(),"Hi");
        wojtek.odebrane();
    }
}
