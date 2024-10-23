package codeExamples.CapitolulPatru.StringBuffer.Exemple.E4_2_24;
//Aflarea lungimii unui sir si a capacitatii StringBuffer-ului
public class AflareLungimeCapacitateSir {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("abcdef");
        int lungime1 = a.length();
        int capacitate1 = a.capacity();
        StringBuffer b = new StringBuffer();
        int lungime2 = b.length();
        int capacitate2 = b.capacity();

        System.out.println("Lungime1 = " + a.length());
        System.out.println("Capacitate1 = " + capacitate1);
        System.out.println("Lungime2 = " + b.length());
        System.out.println("Capacitate1 = " + capacitate2);
    }
}
