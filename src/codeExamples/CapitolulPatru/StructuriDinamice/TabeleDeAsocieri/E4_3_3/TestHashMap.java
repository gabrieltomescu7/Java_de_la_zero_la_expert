package codeExamples.CapitolulPatru.StructuriDinamice.TabeleDeAsocieri.E4_3_3;
//Folosim o tabela cu scopul asocierii unei valori numerice pentru o serie de articole ( de ex o comanda )

import java.util.HashMap;
import java.util.Iterator;

class Articol {
    String denumire;
    float pret;

    public Articol(String denumire, float pret) {
        this.denumire = denumire;
        this.pret = pret;
    }

    public String toString() {
        return denumire + " (" + pret + ")";
    }
}

public class TestHashMap {
    public static void main(String[] args) {
        //construim tabela de asocieri
        HashMap<Articol, Integer> articoleComandate = new HashMap<Articol, Integer>();

        //definim articolele
        Articol[] articole = new Articol[] {
                new Articol("Stilou", 12.50f),
                new Articol("Creion", 1f),
                new Articol("Radiera", 0.5f),
                new Articol("Caiet", 12f)
        };

        //completam tabela de asocieri
        articoleComandate.put(articole[1], 3);
        articoleComandate.put(articole[2], 1);
        articoleComandate.put(articole[3], 0);

        float total = 0;
        Integer cantitate;
        Iterator<Articol> it = articoleComandate.keySet().iterator();
        Articol articol;

        //parcurgem multimea cheilor
        while(it.hasNext()) {
            articol = it.next();
            cantitate = articoleComandate.get(articol);
            //daca produsul nu a fost comandat
            if(cantitate == null) continue;
            //daca produsul a fost comandat si cantitatea este strict pozitiva
            if(cantitate > 0) {
                System.out.println(cantitate + " x " + articol);
                total+= cantitate * articol.pret;
            }
        }

        //afisam totalul
        System.out.println("Total = " + total);
     }
}
