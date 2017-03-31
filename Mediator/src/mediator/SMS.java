/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mediator;

/**
 *
 * @author grzesiek
 */
public class SMS {
    public String nadawca;
    public String odbiorca;
    public String tresc;
    public SMS(String _nadawca, String _odbiorca, String _tresc){
        nadawca = _nadawca;
        odbiorca = _odbiorca;
        tresc = _tresc;
    }
}
