package codeExamples.Capitolul5_Fisiere_Fluxuri_Serializari.Citiri.ClasaSystem.CitiriTastatura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CitiriTastatura {
    public static void main(String[] args) {
        CitiriTastatura obiect = new CitiriTastatura();
        obiect.executa();
    }

    private void executa() {
        BufferedReader tastatura = new BufferedReader(new InputStreamReader(System.in), 1);
        System.out.print("Dati un sir: ");
        try {
            System.out.flush(); // goleste bufferul de iesire la consola
            String linie  = tastatura.readLine();
            System.out.println("Ati tastat " + linie);
        }
        catch (IOException e){
            System.err.println("Intrare de la tastatura " + e.toString());
            System.exit(2);
        }
    }
}
