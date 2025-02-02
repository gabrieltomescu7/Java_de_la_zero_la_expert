package codeExamples.Cap4_Siruri_StructuriDinamice.StringTokenizer.Exemple.E4_2_37;

import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) {
        String data = "22 / 06 / 12 : 30";
        String zi, luna, ora, min;
        StringTokenizer d = new StringTokenizer(data, " /");
        zi = d.nextToken();
        luna = d.nextToken();
        ora = d.nextToken();
        min = d.nextToken(" :");

        System.out.println(zi);
        System.out.println(luna);
        System.out.println(ora);
        System.out.println(min);

    }
}
