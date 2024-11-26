package codeExamples.CapitolulPatru_Siruri_StructuriDinamice.StructuriDinamice.InterfataHashSet_multimi;

import java.util.HashSet;
import java.util.Iterator;

public class TestHashSet {
    public static void main(String[] args) {
        HashSet<Double> hs = new HashSet<Double>();
        hs.add(3.14159);
        hs.add(-2.57);
        hs.add(1.09);

        //nu mai e adaugat inca o data deoarece exista deja
        hs.add(-2.57);

        Iterator<Double> iterator = hs.iterator();
        double suma = 0.0, element;
        while(iterator.hasNext()) {
            element = iterator.next();
            System.out.println(element);
            suma += element;
        }

        System.out.println("Suma este" + suma);
    }
}
