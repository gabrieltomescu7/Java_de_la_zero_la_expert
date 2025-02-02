package codeExamples.Cap4_Siruri_StructuriDinamice.StructuriDinamice.Liste_Vectori.E4_3_10;

import java.util.Vector;

class ClasaGenerica {
    String nume;

    ClasaGenerica(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return nume;
    }
}
public class VectorGeneric {
    public static void main(String[] args) {
        Vector<Object> listaGenerica = new Vector<Object>();

        //popularea vectorului
        listaGenerica.add(new ClasaGenerica("Laguna"));
        listaGenerica.add(112);
        listaGenerica.add("abc");

        //parcurgerea vectorului
        for(int i = 0; i < listaGenerica.size(); i++) {
            Object obiectCurent = listaGenerica.get(i);
            System.out.println("Obiect din clasa " +
                    obiectCurent.getClass().getName() + ": " +obiectCurent);
            if (obiectCurent instanceof Integer) {
                Integer nr =  (Integer) obiectCurent;
                System.out.println("\tAm gasit numarul " + nr);
            }
        }
    }
}
