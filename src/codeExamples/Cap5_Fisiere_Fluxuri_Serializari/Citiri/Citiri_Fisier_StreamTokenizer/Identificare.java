package codeExamples.Cap5_Fisiere_Fluxuri_Serializari.Citiri.Citiri_Fisier_StreamTokenizer;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

import static java.io.StreamTokenizer.*;

public class Identificare {
    public static void main(String[] args) {
        StreamTokenizer parser;
        try {
            /* crearea unui flux de intrare dintr-un fisier care
             va fi parsat de un StreamTokenizer */
            parser = new StreamTokenizer(new FileReader("src/codeExamples/Capitolul5_Fisiere_Fluxuri_Serializari/Citiri/Citiri_Fisier_StreamTokenizer/fisier.txt"));
            /* caracterul # va stabili un comentariu pana la sfarsitul liniei */
            parser.commentChar('#');
            /* vor fi permise comentariile asemenea acestuia */
            parser.slashStarComments(true);
            // sfarsitul de linie va fi ignorat, daca nu e ignorat la intalnire ttype ia valoarea TT_EOL
            parser.eolIsSignificant(false);
            // citirea din flux si parsarea acestuia
            while(parser.nextToken() != StreamTokenizer.TT_EOF)
                //daca am intalnit un numar
                if(parser.ttype == TT_NUMBER)
                    System.out.println("Numar: " + parser.nval);
                //daca s-a identificat un sir de caractere
                else if (parser.ttype == TT_WORD)
                    System.out.println("Cuvant: " + parser.sval);
                else if (parser.ttype == TT_EOL)
                    //mai sus e stabilita ignorarea eols
                    System.out.println("Sfarsit de linie!");
        } // tratarea exceptiilor
        catch (IOException ioe) {
            System.err.println("Eroare de intrare/iesire: " + ioe);
        }
    }

}
