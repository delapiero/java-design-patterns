/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kompozyt;

/**
 *
 * @author grzesiek
 */
public abstract class ObiektWieloczasteczkowy {
    public abstract void przesuniecie(Wektor3d _v);
    public abstract double podajMase();
    public abstract int podajZlozonosc();
    public abstract Wektor3d srodekMasy();
    public abstract Wektor3d srodekGeometryczny();
    @Override
    public abstract String toString();
}
