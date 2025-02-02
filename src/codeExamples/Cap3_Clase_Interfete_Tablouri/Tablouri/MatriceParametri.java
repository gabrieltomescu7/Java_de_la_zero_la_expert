package codeExamples.Cap3_Clase_Interfete_Tablouri.Tablouri;

public class MatriceParametri {
    public static void main(String[] args) {
        int [][] v = new int[2][3];
        initializeazaUnu(v);
        afiseazaMatrice(v);
        int [][] v2 = { {1, 3, 4}, {4 ,6 ,3}};
        afiseazaMatrice(v2);
    }

    static void afiseazaMatrice(int [][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j< a[0].length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }

    static void initializeazaUnu(int [][] a) {
        int numarLinii = a.length;
        int numarColoane = a[0].length;
        for (int i = 0; i < numarLinii; i++)
            for( int j = 0; j < numarColoane; j++)
                a[i][j] = 1;
    }
}
