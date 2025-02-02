package codeExamples.Cap4_Siruri_StructuriDinamice.StringBuffer.Exemple.E4_2_25;

public class CapacitateStringBuffer {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("0123456789");
        int lungime = a.length(); // 10
        int capacitate = a.capacity(); // 26
        a.ensureCapacity(30);
        lungime = a.length(); //10
        capacitate = a.capacity(); //54 = 2 x 26 + 2
    }
}
