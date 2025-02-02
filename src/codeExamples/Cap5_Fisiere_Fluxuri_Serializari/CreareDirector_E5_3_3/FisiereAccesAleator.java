package codeExamples.Cap5_Fisiere_Fluxuri_Serializari.CreareDirector_E5_3_3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FisiereAccesAleator {
    public static void main(String[] args) {
        try {
            RandomAccessFile fisierUnu = new RandomAccessFile("fisier.bin", "rw");
            fisierUnu.writeInt(10000);
            fisierUnu.writeInt(20000);
            fisierUnu.writeInt(30000);
            //vom inlocui in fisier valoarea 20000 cu 40000
            fisierUnu.seek(4);
            fisierUnu.writeInt(40000);
            fisierUnu.close();
        } catch (IOException ioe) {
            System.err.println("Eroare de scriere in fisierUnu " + ioe.toString());
        }

        try {
            //fisier.bin va contine valorile intregi 10000 40000 si 30000
            RandomAccessFile fisierDoi = new RandomAccessFile("fisier.bin", "r");
            //citim primul intreg
            int i = fisierDoi.readInt();
            System.out.println("i1 = " + i + " pointer = " + fisierDoi.getFilePointer());
            //citim al doilea intreg
            i = fisierDoi.readInt();
            System.out.println("i2 = " + i + " pointer = " + fisierDoi.getFilePointer());
            //resetam pointerul catre fisierDoi la zero
            fisierDoi.seek(0);
            //citim patru octeti care formeaza un int
            byte b = fisierDoi.readByte();
            //afisam octetul cel mai semnificativ
            System.out.println("b4 = " + b);
            b = fisierDoi.readByte();
            System.out.println("b3 = " + b);
            b = fisierDoi.readByte();
            System.out.println("b2 = " + b);
            //afisam octetul ce mai nesimnificativ
            b = fisierDoi.readByte();
            System.out.println("b1 = " + b);
            //citim urmatorii opt octeti si ii interpretam ca double
            double d = fisierDoi.readDouble();
            System.err.println("d = " + d);
            fisierDoi.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
