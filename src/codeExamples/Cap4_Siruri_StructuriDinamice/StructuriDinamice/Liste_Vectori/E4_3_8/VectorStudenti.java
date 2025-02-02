package codeExamples.Cap4_Siruri_StructuriDinamice.StructuriDinamice.Liste_Vectori.E4_3_8;

import java.util.Vector;

class Student {
    int numarMatricol;
    String nume, prenume;
    float media;

    public Student(int numarMatricol, String nume, String prenume, float media) {
        this.numarMatricol = numarMatricol;
        this.nume = nume;
        this.prenume = prenume;
        this.media = media;
    }

    @Override
    public String toString() {
        return "Student{" +
                "numarMatricol=" + numarMatricol +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", media=" + media +
                '}';
    }
}
public class VectorStudenti {
    public static void main(String[] args) {
        Vector<Student> listaStudenti = new Vector<Student>();
        listaStudenti.addElement(new Student(52321, "Trufanada", "Viorel", 9.99f));
        listaStudenti.addElement(new Student(52322, "Raicu", "Florin", 8.99f));
        listaStudenti.addElement(new Student(52426, "Munteanu", "Loredana", 9.49f));

        for(int i = 0; i < listaStudenti.size(); i++) {
            Student stud = listaStudenti.get(i);
            System.out.println("\nStudent " + i + "\n");
            System.out.println(stud);
        }
    }

}
