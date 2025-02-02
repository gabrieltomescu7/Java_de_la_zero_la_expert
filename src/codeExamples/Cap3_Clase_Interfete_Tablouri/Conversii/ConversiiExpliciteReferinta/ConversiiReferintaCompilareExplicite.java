package codeExamples.Cap3_Clase_Interfete_Tablouri.Conversii.ConversiiExpliciteReferinta;

class C1 { int x; }

class C2 extends C1 { int y; }

interface I1 { void f(int x);}

class C3 extends C1 implements I1 {
    int x;
    public void f(int x) { this.x = x;}
}
public class ConversiiReferintaCompilareExplicite {
    public static void main(String[] args) {
        //Asignari de variabile de tip clasa
        C1 obiectUnu = new C1();
        C2 obiectDoi = new C2();
        //asignarea este posibila deoarece C2 este subclasa a lui C1
        obiectUnu = obiectDoi;
        //reciproc asignarea ete posibila deoarece este necesara o conversie explicita
        //de forma (C2)
        obiectDoi = (C2) obiectUnu;
        //Asignari de variabile de tip ionterfata
        C3 obiectTrei = new C3();
        //asignarea este posibila la compilare deoarece este
        //facuta o conversie explicita. Totusi, depinde de tipul de la executie
        // al lui obiectUnu. Este necesara o verificare la executie
        // a tipului lui obiectUnu.
        //obiectUnu poate sa nu apartina nici lui C3, nici unei subclase a acestuia.
        obiectTrei = (C3) obiectUnu;
        //asignarea este posibila deoarece clasa C3 implementeaza I1
        I1 obiectPatru = obiectTrei;
        //La fel ca mai sus, asignarea este posibila la compilare, insa nu mai este
        //posibila la executie, deoarece obiectUnu poate sa nu implementeze interfata I1.
        obiectPatru = (I1) obiectUnu;
    }

}
