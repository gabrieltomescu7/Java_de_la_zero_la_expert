package codeExamples.CapitolulPatru_Siruri_StructuriDinamice.StructuriDinamice.BitSet;

import java.util.BitSet;

public class BitSetTest {
    public static void main(String[] args) {
        BitSet bs1 = new BitSet(4);
        BitSet bs2 = new BitSet(4);

        //setam bs1 = ( true, false, true, true)
        bs1.set(0);
        bs1.clear(1);
        bs1.set(2,4);
        System.out.println(bs1);

        //setam bs1 cu toti bitii activati
        for( int i=0; i<bs1.length(); i++) {
            bs2.set(i);
        }

        //inverseaza bs1 cu bs2 folosing metoda XOR
        bs1.xor(bs2);
        System.out.println(bs1);// se va afisa 1

        System.out.println("========");
        System.out.println(System.getProperties());

        System.getProperties().list(System.out);
    }
}
