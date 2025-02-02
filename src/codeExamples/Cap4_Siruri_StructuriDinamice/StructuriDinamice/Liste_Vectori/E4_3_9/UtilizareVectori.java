package codeExamples.Cap4_Siruri_StructuriDinamice.StructuriDinamice.Liste_Vectori.E4_3_9;

import java.util.Vector;

//Conversia dintr-un sir de intregi (int) la un Vector de Integer
public class UtilizareVectori {
    public static void main(String[] args) {
        int tablouFix [] = {1, 3, 0, 5, 3, 0, 3, 4, 0, 2, 0, 0, 5, 12345};
        Vector<Integer> listaIntregi = new Vector<Integer>();
        //variabila listaIntregi va contine elementele din tablouFix care sunt nenule
        for(int i = 0; i < tablouFix.length; i++) {
            if(tablouFix[i] != 0)
                listaIntregi.add(tablouFix[i]);
        }

        for (int i = 0; i< listaIntregi.size(); i++) {
            int valoare = listaIntregi.get(i);
            System.out.println("Element " + i + ": " + valoare);
        }
        //float val = 2/5f;
        //System.out.printf("%.6f", val); // printeaza 0.400000
    }
}
