package codeExamples.Cap5_Fisiere_Fluxuri_Serializari.Serializari.ImplementareSerializable.E5_4_6;

import java.io.*;

import static java.lang.Math.pow;

class CercDoi implements Serializable {
    protected double x, y, raza;
    public CercDoi(double x, double y, double raza) {
     this.x = x;
     this.y = y;
     this.raza = raza;
    }
    public boolean punctInterior( double x, double y) {
        return (this.x - x) * (this.x - x) + (this.y - y) * (this.y - y) <= pow(raza, 2);
    }
    public String toString() {
        return "Centrul (" + x + ", " + y + "), raza " + raza;
    }
}

public class TestCercDoiSerializare {
    public static void main(String[] args) {
        CercDoi obiect = new CercDoi(0, 0, 10);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("cerc.dat"));
            oos.writeObject(obiect);
            oos.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.err.println("Eroare la serializare");
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("cerc.dat"));
            CercDoi obiectCitit = (CercDoi) ois.readObject(); //down-casting de la Object la CercDoi
            System.out.println(obiectCitit);
            ois.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.err.println("Eroare la deserializare" + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.err.println("N-am gasit clasa obiectului in flux" + cnfe.getMessage());
        }
    }

}
