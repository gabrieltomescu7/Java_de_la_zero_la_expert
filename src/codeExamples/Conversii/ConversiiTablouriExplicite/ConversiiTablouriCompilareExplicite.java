package codeExamples.Conversii.ConversiiTablouriExplicite;
class C1 { int x;}

class C2 extends C1 { int y; }


public class ConversiiTablouriCompilareExplicite {
    public static void main(String[] args) {
        //Asignari de variabile de tip tablou
        int [] a = new int[5];
        //asignarea este posibila deoarece int[] este subclasa a lui Object
        Object o = a;
        //Valoarea lui a nu se poate asigna lui b, deoarece a
        //este tablou cu componente primitive, in timp ce
        //Integer nu este tip primitiv ci referinta.
        //Se obtine eroare la compilare
        //--Integer [] b = a;
        //Valoarea lui a nu se poate asigna lui c, deoarece a si
        //c sunt tablouri cu componente de tipuri diferite.
        //Se obtine eroare la compilare
        //--short [] c = a;
        C1 [] obiectUnu = new C1[10];
        C2 [] obiectDoi = new C2[11];
        // asignarea este corecta deoarece C2 este subclasa a lui C1
        obiectUnu = obiectDoi;
        //asignarea este corecta la faza de compilare, dar va arunca o exceptie
        //ArrayStoreException la executie
        obiectUnu[0] = new C1();
        //asignarea nu este posibila, se obtine eroare la compilare
        //--obiectDoi = obiectUnu;

    }
}
