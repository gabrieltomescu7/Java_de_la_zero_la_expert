package codeExamples.Interfete.MostenireMultipla;
import java.io.*;

public class AplicatieElectronice {
    private BufferedReader tastatura;
    private int totalPutere;
    private int timp, volum;

    public static void main(String[] args) {
        AplicatieElectronice obiect  = new AplicatieElectronice();
        TV tv = new TV();
        obiect.citesteTimp();
        tv.setTimpFolosinta(obiect.timp);
        tv.schimbaVolum(1);
        obiect.calculeazaPutereConsumata(tv);
        obiect.afiseaza("tv", tv.getVolum(), tv.getTimpFolosinta(), obiect.totalPutere);
        tv.setTimpFolosinta(0);
        Aspirator aspirator = new Aspirator();
        obiect.citesteTimp();
        aspirator.setTimpFolosinta(obiect.timp);
        aspirator.schimbaVolum(2);
        obiect.calculeazaPutereConsumata(aspirator);
        obiect.afiseaza("aspirator", aspirator.getVolum(), aspirator.getTimpFolosinta(), obiect.totalPutere);
        aspirator.setTimpFolosinta(0);
    }

    private void citesteTimp() {
        try {
            tastatura = new BufferedReader(
                    new InputStreamReader(System.in), 1);
            System.out.println("Dati timpul (in minute): ");
            System.out.flush();
            String linie = tastatura.readLine();
            try {
                timp = Integer.parseInt(linie);
            } catch (NumberFormatException ex) {
                System.err.println("Format de intreg gresit : " + ex);
                System.exit(3);
            }
        }
        catch (IOException e) {
            System.err.println("Intrare gresita de la tastatura: " + e);
            System.exit(2);
        }
    }

    public void afiseaza( String s, int v, int timpUtilizat, int putere) {
        if(s.equals("tv")) {
            System.out.println("TV-ul are volumul " + v);
            System.out.println("si a fost utilizat timp de " + timpUtilizat + " minute.");
            System.out.println("Puterea totala a fost " + putere);
        }
        else
            if (s.equals("aspirator")) {
                System.out.println("Aspiratorul are viteza " + v);
                System.out.println("si a fost utilizat timp de " + timpUtilizat + " minute.");
                 System.out.println("Puterea totala a fost " + putere);
            }
    }

    public void calculeazaPutereConsumata(DispozitiveElectronice dispozitiv) {
        int putere = dispozitiv.getTimpFolosinta() * dispozitiv.getPutere();
        totalPutere = totalPutere + putere;
    }
}
