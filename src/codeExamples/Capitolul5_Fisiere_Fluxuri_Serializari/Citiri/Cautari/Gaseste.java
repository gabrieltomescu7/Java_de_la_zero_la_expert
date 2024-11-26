package codeExamples.Capitolul5_Fisiere_Fluxuri_Serializari.Citiri.Cautari;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gaseste {
    private String linia1, linia2 , linia3;
    private BufferedReader tastatura, fluxIntrare;

    public static void main(String[] args) {
        Gaseste gaseste = new Gaseste();
        gaseste.cauta(args[0]);
    }

    //metoda care realizeaza cautarea efectiva
    private void cauta(String numeFisier) {
        tastatura = new BufferedReader(new InputStreamReader(System.in),1);
        String sir;
        //se apeleaza metoda prompt() care intoarce sirul citit de la tastatura
        sir = prompt("Dati sirul ce trebuie cautat: ");
        linia1 = "";
        linia2 = "";
        try {
            fluxIntrare = new BufferedReader(new FileReader(numeFisier));
            //in linia3 se va citi cate o linie din fisierul de intrare
            while ((linia3 = fluxIntrare.readLine()) != null) {
                /*daca linia2 contine sirul citit de la tastatura
                se va afisa linia in care apare (linia2) si contextul
                (o linie inainte si una dupa)
                 */
                if(linia2.indexOf(sir) >= 0)
                    afiseazaLinia();
                //se pastreaza ultimele doua linii
                linia1 = linia2;
                linia2 = linia3;
            }
            //am ajuns la sf fisierului
            linia3 = "";
            //testam daca sirul cautat apare pe ultima linie
            if(linia2.indexOf(sir) >= 0)
                afiseazaLinia();
            //inchidem fisierul de intrare
            fluxIntrare.close();
        }
        catch (IOException ioe) {
            System.err.println("Eroare la cautarea sirului: " + ioe.toString());
            System.exit(1);
        }
    }

    //aceasta metoda afiseaza linia gasita si contextul in care apare
    private void afiseazaLinia() {
        System.out.println("<<-- context:");
        System.out.println(linia1);
        System.out.println(linia2);
        System.out.println(linia3);
        System.out.println("                    -->>");
        System.out.println("");
    }

    /*aceasta metoda afiseaza sirul de caractere primit (mesaj)
    si citeste un sir de caractere de la tastatura
     */

    private String prompt(String mesaj) {
        String raspuns = "";
        try {
            System.out.print(mesaj);
            System.out.flush();
            raspuns = tastatura.readLine();
        }
        catch (IOException e){
        System.err.println("Eroare la citirea de la tastatura: " + e.toString());
        System.exit(2);
        }
        return raspuns;
    }
}
