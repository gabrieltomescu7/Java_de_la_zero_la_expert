package codeExamples.Cap6_Fire_de_executie.E6_3_1_PrimulFir;

public class PrimulFir {
    public static void main(String[] args) {
        System.out.println("Crearea firului");
        FirExecutie fir = new FirExecutie();
        System.out.println("Startam firul de executie");
        fir.start();
        System.out.println("Revenim in main()");
    }
}

class FirExecutie extends Thread {
    public void run() {
        int numarPasi = 5;
        System.out.println("Run se executa de " + numarPasi + " ori." );
        for ( int i = 1; i <= numarPasi; i++)
            System.out.println("Pasul " + i);
        System.out.println("Run si-a terminat trb.");
    }
}