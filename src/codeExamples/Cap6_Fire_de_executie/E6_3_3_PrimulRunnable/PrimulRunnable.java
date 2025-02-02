package codeExamples.Cap6_Fire_de_executie.E6_3_3_PrimulRunnable;

import java.sql.SQLOutput;

public class PrimulRunnable {
    public static void main(String[] args) {
        System.out.println("Crearea obiectului runnable");
        Tinta tinta = new Tinta();
        System.out.println("Cream firul de executie");
        Thread fir = new Thread(tinta);
        System.out.println("Startam firul de executie");
        fir.start();
        System.out.println("Revenim in main()");

    }
}

class Afisare {
    public void afisare (String mesaj) {
        System.out.println(mesaj);
    }
}

class Tinta extends Afisare implements Runnable {
    public void run() {
        int numarPasi = 5;
        afisare("Run executa " + numarPasi + " pasi.");
        for(int i = 1; i <= numarPasi; i++)
            afisare("Pasul " + i);
        afisare("Run si-a terminat treaba.");
    }
}