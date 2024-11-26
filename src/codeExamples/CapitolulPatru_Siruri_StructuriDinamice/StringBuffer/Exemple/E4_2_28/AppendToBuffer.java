package codeExamples.CapitolulPatru_Siruri_StructuriDinamice.StringBuffer.Exemple.E4_2_28;

public class AppendToBuffer {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("abc");
        String b = "defghi";
        a.ensureCapacity(10);
        a.append(b, 2, 4);
        System.out.println(a);
    }
}
