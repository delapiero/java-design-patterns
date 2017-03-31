package fasada;

/**
 *
 * @author grzesiek
 */
public class Fasada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Astronom galileusz = new Astronom();
        int gwiazdy  = galileusz.gwiazdozbiory();
        System.out.println("Łącznie gwiazd:" + Integer.toString(gwiazdy));
    }
}
