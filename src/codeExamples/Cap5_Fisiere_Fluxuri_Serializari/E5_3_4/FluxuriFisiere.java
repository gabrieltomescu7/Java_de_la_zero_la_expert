package codeExamples.Cap5_Fisiere_Fluxuri_Serializari.E5_3_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FluxuriFisiere {
    public static void main(String[] args) {
        int i;
        try {
            FileOutputStream fisierUnu = new FileOutputStream("fisier.txt");
            //declaram date de tip byte
            byte b = 5;
            //tipul byte range [-128 - 127] - memorat pe un sg octet
            byte vectorUnu[] = {(byte) 2, (byte) -128, (byte) 127, (byte) 0, (byte) 6, (byte) -8};
            fisierUnu.write(b);
            fisierUnu.write(vectorUnu);
            fisierUnu.close();

            FileInputStream fisierDoi = new FileInputStream("fisier.txt");
            int bInt = fisierDoi.read();
            //functia read() intoarce -1 daca am ajuns la e.o.f
            System.out.println(bInt + " = bInt ");
            System.out.println("disponibil = " + fisierDoi.available());
            b = (byte) fisierDoi.read();
            System.out.println(b + " = b ");
            b = (byte) fisierDoi.read();
            System.out.println(b + " = b ");
            byte vectorDoi[] = new byte[10];
            int spatiulRamas = fisierDoi.available();
            System.out.println("disponibil = " + fisierDoi.available());
            fisierDoi.read(vectorDoi);

            for (i = 0; i < spatiulRamas; i++)
                System.out.println("vectorDoi[" + i + "]  = " + vectorDoi[i]);
            b = (byte) fisierDoi.read();
            //functia read() intoarce -1 daca am ajuns la sfarsitul fisierului
            System.out.println(b + " ");
            fisierDoi.close();

        } catch (FileNotFoundException fnfe) {
            throw new RuntimeException(fnfe);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
