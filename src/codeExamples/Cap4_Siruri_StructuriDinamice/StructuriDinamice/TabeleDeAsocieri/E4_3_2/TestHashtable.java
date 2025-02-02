package codeExamples.Cap4_Siruri_StructuriDinamice.StructuriDinamice.TabeleDeAsocieri.E4_3_2;
//Pentru o valoare numerica reprezentand un identificator unic al unui angajat (marca) se asociaza un obiect corespunzator angajatului.
import java.util.Hashtable;

class Angajat {
    String nume, prenume;

    public Angajat(String nume, String prenume){
        this.nume = nume;
        this.prenume = prenume;
    }

    public String toString() {
        return prenume + " " + nume;
    }
}
public class TestHashtable {
    public static void main(String[] args) {
        Hashtable<Integer, Angajat> tabel = new Hashtable<Integer, Angajat>();
        tabel.put(3, new Angajat("Ionescu", "Vlad"));
        tabel.put(5, new Angajat("Zamfir", "Bogdan"));
        tabel.put(9, new Angajat("Golescu", "Nicu"));

        Angajat angajat = tabel.get(5);
        System.out.println(angajat);
    }
}
