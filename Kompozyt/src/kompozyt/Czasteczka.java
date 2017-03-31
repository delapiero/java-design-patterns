/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kompozyt;

/**
 *
 * @author grzesiek
 */

public class Czasteczka extends ObiektWieloczasteczkowy {
    
    private Wektor3d v;
    private double masa; 
    
    public Czasteczka(Wektor3d _v, double _masa){
        v = _v;
        masa = _masa;
    }

    @Override   
    public void przesuniecie(Wektor3d _v){
        v.x += _v.x;
        v.y += _v.y;
        v.z += _v.z;
    }

    @Override
    public double podajMase() {
        return masa;
    }
    
    @Override
    public int podajZlozonosc() {
        return 1;
    }
    
    @Override
    public Wektor3d srodekMasy() {
        return v;
    }

    @Override
    public Wektor3d srodekGeometryczny() {
        return v;
    }
    
    @Override
    public String toString(){
        return v.x + " " + v.y + " " + v.z + " - " + masa + "\n";
    }
}
