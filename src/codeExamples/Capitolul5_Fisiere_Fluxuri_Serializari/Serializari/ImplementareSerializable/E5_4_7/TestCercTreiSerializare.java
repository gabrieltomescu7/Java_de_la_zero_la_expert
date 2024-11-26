package codeExamples.Capitolul5_Fisiere_Fluxuri_Serializari.Serializari.ImplementareSerializable.E5_4_7;

import java.io.*;

import static java.lang.Math.pow;

// Datele marcate transient ( date care prin natura lor sunt unice ),
// Datele statice ( globale masinii virtuale ),
// nu pot fi transmise de Fluxurile de Obiecte
// de aceea trebuie refacute prin metoda readObject() implementata de clasa serializabila

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

class CercTrei extends CercDoi {
    private transient double patratulRazei;
    private transient int id;

    private static int globalId;
    private synchronized static int getId() {
        return globalId++;
    }

    public CercTrei() { super(0,0,0); }

    public CercTrei( double x, double y, double raza) throws IOException {
        super(x, y, raza);
        patratulRazei = raza * raza;
        id = getId();
    }

    public boolean punctInterior( double x, double y) {
        return (this.x - x) * (this.x - x) + (this.y - y) * (this.y - y) <= patratulRazei;
    }

    public void writeObject(ObjectOutputStream obiectIesire) throws IOException {
        obiectIesire.writeDouble(x);
        obiectIesire.writeDouble(y);
        obiectIesire.writeDouble(raza);
    }

    public void readObject(ObjectInputStream obiectIntrare) throws IOException, ClassNotFoundException {
        x = obiectIntrare.readDouble();
        y = obiectIntrare.readDouble();
        raza = obiectIntrare.readDouble();
        patratulRazei = raza * raza;
        id = getId();
    }

    public String toString() {
        return "Centrul (" + x + ", " + y + "), raza " + raza +
                " patratul Razei = " + patratulRazei + "\n id = " + id +
                " globalId = " + globalId;
    }
}

public class TestCercTreiSerializare {
    public static void main(String[] args) {
        CercTrei obiect = null;
        try {
            obiect = new CercTrei(1, 1, 10);
        } catch (IOException e) {
            System.err.println("Eroare la creare obiect din Clasa CercTrei");
        }
        System.out.println("obiect = " + obiect);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("cerc1.dat"));
            obiect.writeObject(oos);
            oos.close();
        }
        catch (IOException ioe) {
            System.err.println("Eroare la serializare " + ioe.getMessage());
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("cerc1.dat"));
            CercTrei obiectCitit = new CercTrei();
            obiectCitit.readObject(ois);
            System.out.println(obiectCitit);
            ois.close();
        } catch (IOException e) {
            System.err.println("Eroare la deserializare " + e.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.err.println("N-am gasit clasa obiectului in flux" + cnfe.getMessage());
        }
    }
}
