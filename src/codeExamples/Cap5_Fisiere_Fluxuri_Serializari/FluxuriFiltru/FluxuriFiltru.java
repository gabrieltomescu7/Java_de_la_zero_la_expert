package codeExamples.Cap5_Fisiere_Fluxuri_Serializari.FluxuriFiltru;

import java.io.*;

public class FluxuriFiltru {
    public static void main(String[] args) {
        try {
            FileOutputStream fisierUnu = new FileOutputStream("fisierUnu.out");
            DataOutputStream fisierDateUnu = new DataOutputStream(fisierUnu);
            fisierDateUnu.writeByte(127);
            fisierDateUnu.writeInt(123456);
            fisierDateUnu.writeDouble(12.34);
            fisierDateUnu.writeUTF("123\u5555");
            fisierDateUnu.writeUTF(" Scriem acest text in fisier.");
            fisierDateUnu.writeInt(-1);
            fisierDateUnu.close();
            fisierUnu.close();

            System.out.println("Urmeaza citirea din fisier");
            //urmeaza citirea acestui fisier si afisarea datelor
            FileInputStream fisierDoi = new FileInputStream("fisierUnu.out");
            DataInputStream fisierDateDoi = new DataInputStream(fisierDoi);
            byte b = fisierDateDoi.readByte();
            int i = fisierDateDoi.readInt();
            double d = fisierDateDoi.readDouble();
            String sir1 = fisierDateDoi.readUTF();
            String sir2 = fisierDateDoi.readUTF();
            System.out.println("b = " + b);
            System.out.println("i = " + i);
            i = fisierDateDoi.readInt();
            System.out.println("i = " + i);
            System.out.println("d = " + d);
            System.out.println("sir1 = " + sir1);
            System.out.println("sir2 = " + sir2);
            fisierDateDoi.close();
            fisierDoi.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
