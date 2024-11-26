package codeExamples.Capitolul5_Fisiere_Fluxuri_Serializari.CreareDirector_E5_3_1;
import java.io.File;

public class Fisiere {
    public static void main(String[] args) {
        boolean reusita;
        File dirNou = new File("C:\\dirProba");
        if (dirNou.isDirectory())
            System.out.println("Directorul C:\\dirProba exista deja!");
        reusita = dirNou.mkdir();
        if (reusita)
            System.out.println("Am reusit sa cream directorul" + "C:\\dirProba");
        else
            System.out.println("Nu am creat directorul " + "C:\\dirProba!");
    }
}
