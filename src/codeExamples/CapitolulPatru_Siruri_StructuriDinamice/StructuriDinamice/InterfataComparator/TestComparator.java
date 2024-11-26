package codeExamples.CapitolulPatru_Siruri_StructuriDinamice.StructuriDinamice.InterfataComparator;

import java.util.Comparator;

class Produs {
    int greutate;
    float pret;

    public Produs(int greutate, float pret) {
        this.greutate = greutate;
        this.pret = pret;
    }
}

class ComparaProduseleDupaGreutate implements Comparator<Produs> {
    public int compare(Produs p1, Produs p2) {
        return p1.greutate - p2.greutate;
    }
}

class ComparaProduseleDupaPret implements Comparator<Produs> {
    public int compare(Produs p1, Produs p2) {
        return (int) Math.signum(p1.pret - p2.pret);
    }
}
public class TestComparator {
    public static void main(String[] args) {
        Produs p1 = new Produs(230,15.13f);
        Produs p2 = new Produs(330, 10.99f);

        Comparator<Produs> comparator;

        comparator = new ComparaProduseleDupaGreutate();
        System.out.println(comparator.compare(p1,p2));

        comparator = new ComparaProduseleDupaPret();
        System.out.println(comparator.compare(p1,p2));
    }


}
