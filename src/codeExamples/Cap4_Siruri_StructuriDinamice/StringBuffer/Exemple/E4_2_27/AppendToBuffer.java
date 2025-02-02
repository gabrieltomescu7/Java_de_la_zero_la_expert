package codeExamples.Cap4_Siruri_StructuriDinamice.StringBuffer.Exemple.E4_2_27;

public class AppendToBuffer {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("abc");
        StringBuffer b = a.append("def"); // a si b devin abcdef
        b.setLength(4);
        System.out.println(a); // va fi "abcd"
    }
}
