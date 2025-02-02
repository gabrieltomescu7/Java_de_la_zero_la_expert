package codeExamples.Cap6_Fire_de_executie.E6_3_2_AlDoileaFir;

public class AlDoileaFir {
    public static void main(String[] args) {
        FirDeExecutie fir1 = new FirDeExecutie("FIR1");
        FirDeExecutie fir2 = new FirDeExecutie("FIR2");
        System.out.println(
                "JVM va crea contextul celor doua fire de executie!"
        );
        fir1.start();
        fir2.start();
        System.out.println("JVM a creat contextul celor doua fire de executie!");
    }
}

class FirDeExecutie extends Thread {
    private String numeFir;
    public FirDeExecutie( String nume) {
        this.numeFir = nume;
    }
    public void run() {
        int numarPasi = 5;
        System.out.println("Run se executa de " + numarPasi + " ori.");

        for(int i = 1 ; i <= numarPasi; i++) {
            System.out.println(numeFir + "este la pasul " + i);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                System.err.println("Eroare in somn");
            }
        }
        System.out.println(numeFir + "Si-a terminat treaba");

    }
}
