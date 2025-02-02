package codeExamples.Cap4_Siruri_StructuriDinamice.StringTokenizer.Exemple.E4_2_38;

import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) {
        String exemplu = "4,6 ,7, 10, 15 ,20";
        String element;

        StringTokenizer listaNumere = new StringTokenizer(exemplu, " ,");
        while(listaNumere.hasMoreTokens()) {
            element = listaNumere.nextToken();
            System.out.println(element);
        }
    }

}
