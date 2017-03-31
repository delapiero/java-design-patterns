package fasada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 *
 * @author grzesiek
 */
public class Astronom {
    
    private void gwiazdozbior(String skrypt){
        try {
            ProcessBuilder pb = new ProcessBuilder("astronom.exe",skrypt);
            Process p = pb.start();
            InputStream in = p.getInputStream();
            OutputStream out = p.getOutputStream();    
            InputStream err = p.getErrorStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            String line;

            while ((line = br.readLine()) != null) {
              System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public int orion(){
        System.out.println("Orion");
        gwiazdozbior("orion.txt");
        return liczbaGwiazd("orion.txt");
    }
    
    public int wielkiWoz(){
        System.out.println("Wielki Woz");
        gwiazdozbior("wielkiwoz.txt");
        return liczbaGwiazd("wielkiwoz.txt");
    }
    
    public int krzyzPoludnia(){
        System.out.println("Krzyż Południa");
        gwiazdozbior("krzyzpoludnia.txt");
        return liczbaGwiazd("krzyzpoludnia.txt");
    }
    
    public int koronaPolnocna(){
        System.out.println("Korona Północna");
        gwiazdozbior("koronapolnocna.txt");
        return liczbaGwiazd("koronapolnocna.txt");
    }
    
    public int kasjopea(){
        System.out.println("Kasjopea");
        gwiazdozbior("kasjopea.txt");
        return liczbaGwiazd("kasjopea.txt");
    }
    
    public int zyrafa(){
        System.out.println("Żyrafa");
        gwiazdozbior("zyrafa.txt");
        return liczbaGwiazd("zyrafa.txt");
    }
    
    public int puchar(){
        System.out.println("Puchar");
        gwiazdozbior("puchar.txt");
        return liczbaGwiazd("puchar.txt");
    }
    
    public int lew(){
        System.out.println("Lew");
        gwiazdozbior("lew.txt");
        return liczbaGwiazd("lew.txt");
    }
    
    public int gwiazdozbiory(){
        int licznik = 0;
        licznik += orion();
        licznik += wielkiWoz();
        licznik += krzyzPoludnia();
        licznik += koronaPolnocna();
        licznik += kasjopea();
        licznik += zyrafa();
        licznik += puchar();
        licznik += lew();
        return licznik;
    }

    private int liczbaGwiazd(String skrypt){
        String line = "0";
        try {
            ProcessBuilder pb = new ProcessBuilder("astrofizyk.exe",skrypt);
            Process p = pb.start();
            InputStream in = p.getInputStream();
            OutputStream out = p.getOutputStream();    
            InputStream err = p.getErrorStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);        
            line = br.readLine();

        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return (Integer.parseInt(line));
    }
    
}
