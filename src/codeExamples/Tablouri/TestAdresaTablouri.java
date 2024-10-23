package codeExamples.Tablouri;

public class TestAdresaTablouri {
    public static void main(String[] args) {
        int v[] = {2, 3};
        System.out.println("Inainte de apel, adresa lui v este " + v.hashCode());
        afiseazaTablou(v);
        f(v);
        System.out.println("Dupa apel, adresa lui v este " + v.hashCode());
        afiseazaTablou(v);
    }

    public static void f( int [] sir) {
        int w[] = {5, 6};
        sir = w;
        System.out.println("In metoda f(), adresa lui sir este " + sir.hashCode());
        afiseazaTablou(sir);
    }

    static void afiseazaTablou(int [] sir) {
        System.out.println("Tabloul este: ");
        for (int i = 0; i < sir.length; i++)
            System.out.print(sir[i] + " ");
        System.out.println();
    }
}
