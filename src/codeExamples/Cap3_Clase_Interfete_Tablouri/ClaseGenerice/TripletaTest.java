package codeExamples.Cap3_Clase_Interfete_Tablouri.ClaseGenerice;
class Tripleta<T1,T2,T3> {
    T1 t1;
    T2 t2;
    T3 t3;

    public Tripleta() {
    }
    public Tripleta(T1 t1, T2 t2, T3 t3) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }

    public String toString() {
        return
                t1.getClass().getName() + " - " +
                        t2.getClass().getName() + " - " +
                        t3.getClass().getName() + "\n" +
                        t1.toString() + " - " +
                        t2.toString() + " - " +
                        t3.toString();
    }
}

public class TripletaTest {
    public static void main(String[] args) {
        Tripleta tripleta1 = new Tripleta<Integer, String, Double>(-2, "qiu", 5.1);
        System.out.println(tripleta1);

        Tripleta<String, String, Double> tripleta2 = new Tripleta<String, String, Double>();
        tripleta2.t1 = "alfa";
        tripleta2.t2 = "qiu";
        tripleta2.t3 = 5.1;
        System.out.println(tripleta2);
    }
}
