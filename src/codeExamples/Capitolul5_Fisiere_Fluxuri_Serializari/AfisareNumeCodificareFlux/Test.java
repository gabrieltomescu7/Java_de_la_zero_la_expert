package codeExamples.Capitolul5_Fisiere_Fluxuri_Serializari.AfisareNumeCodificareFlux;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("fisier.in");
            InputStreamReader isr = new InputStreamReader(fis);
            System.out.println("codificarea este " + isr.getEncoding());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
