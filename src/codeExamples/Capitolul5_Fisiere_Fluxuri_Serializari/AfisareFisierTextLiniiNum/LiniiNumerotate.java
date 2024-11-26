package codeExamples.Capitolul5_Fisiere_Fluxuri_Serializari.AfisareFisierTextLiniiNum;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LiniiNumerotate {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("C:\\Users\\gabriel.tomescu0711\\IdeaProjects\\Java_de_la_zero_la_expert\\src\\codeExamples\\Capitolul5_Fisiere_Fluxuri_Serializari\\AfisareFisierTextLiniiNum\\LiniiNumerotate.java");
            LineNumberReader lnr = new LineNumberReader(fr);
            String s;
            while ((s = lnr.readLine()) != null) {
                System.err.println(lnr.getLineNumber() + ": " + s);
            }
            lnr.close();
            fr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
