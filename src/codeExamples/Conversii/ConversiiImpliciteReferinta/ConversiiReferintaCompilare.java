package codeExamples.Conversii.ConversiiImpliciteReferinta;

class C1 { int x ;}

class C2 extends C1 { int y;}

interface I1 { void f(int x );}

class C3 extends C1 implements I1 {
    int x;
    public void f ( int x ) { this.x = x; }
}
public class ConversiiReferintaCompilare {
    public static void main(String[] args) {
        // Asignari de variabile de tip clasa
        C1 obiectUnu = new C1();
        //asignarea este posibila deoarece C2 este sublclasa a lui C1
        obiectUnu = new C2();
        //reciproc asignarea nu este posibila deoarece este necesara o conversie explicita
        // de forma (C2)
        //C2 obiectDoi = obiectUnu;
        //Asignari de variabile de tip Object
        //asignarea este posibila deoarece C1 este sublcasa a lui Object
        Object obiectTrei = obiectUnu;
        int[] a = new int [3];
        //asignarea este posibila deoarece clasa tablou este sublcasa a lui Object
        Object obiectPatru = a;
        //Asignari de variabile de tip interfata
        C3 obiectCinci = new C3();
        //asignarea este posibila deoarece clasa C3 implementeaza I1
        I1 obiectSase = obiectCinci;
        //Asignari de variabile de tip tablou
        byte[] b = new byte [4];
        //asignarea nu este pobisibila deoarece tablourile a si b nu sunt definite
        // pe acelasi tip primitiv
        //a = b;
        C2 [] obiectSapte = new C2 [3];
        // asignarea este posibila deoaree C2 este subclasa a lui C1
        C1[] obiectOpt = obiectSapte;
        // asignarea nu este posibila fiind necesara o conversie explicita la (C2 [])
        //obiectSapte = obiectOpt;
    }
}
