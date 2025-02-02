package codeExamples.Cap4_Siruri_StructuriDinamice.StructuriDinamice.InterfataComparable;

class Zi implements Comparable<Zi>{
    private int zi, luna;

    public Zi(int zi, int luna) {
        this.zi = zi;
        this.luna = luna;
    }

    public int compareTo(Zi o){
        int result = luna - o.luna;
        return result == 0 ? zi - o.zi : result;
    }
}
public class TestComparable {
    public static void main(String[] args) {
        Zi[] zile = new Zi[] {
                new Zi(21,3),
                new Zi(22, 3),
                new Zi(22, 5)
        };
        System.out.println(zile[0].compareTo(zile[1]));
        System.out.println(zile[1].compareTo(zile[2]));
        System.out.println(zile[0].compareTo(zile[2]));
    }
}
