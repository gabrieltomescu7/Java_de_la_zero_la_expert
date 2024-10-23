package codeExamples.Tablouri;

public class TransmitereTablouriParametri {
    public static void main(String[] args) {
        int [] a = new int[5];
        afiseazaSir(a);
        initializeazaSir(a);
        afiseazaSir(a);
    }

    static void initializeazaSir(int [] sir) {
        for(int i = 0; i < sir.length; i++)
            sir[i] = 1;
    }

    static void afiseazaSir(int [] sir) {
        for(int i = 0; i < sir.length; i++)
            System.out.print(sir[i] + " ");
        System.out.println();
    }
}
