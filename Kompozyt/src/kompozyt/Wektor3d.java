/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kompozyt;

/**
 *
 * @author grzesiek
 */
public class Wektor3d {
    public double x,y,z;
    
    public Wektor3d(double _x, double _y, double _z){
        x = _x;
        y = _y;
        z = _z;
    }
    
    public Wektor3d(Wektor3d _v){
        x = _v.x;
        y = _v.y;
        z = _v.z;
    }
    
    @Override
    public String toString(){
        return x + " " + y + " " + z + "\n";
    }
}
