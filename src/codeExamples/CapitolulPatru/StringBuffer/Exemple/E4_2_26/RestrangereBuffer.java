package codeExamples.CapitolulPatru.StringBuffer.Exemple.E4_2_26;

public class RestrangereBuffer {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("0123456789");
        a.setLength(8);
        System.out.println(a); //01234567 - truncherea ultimelor 2 elemente
    }
}
