package codeExamples.Interfete.AtributeAmbigue;

interface I0 {
    int x = 3;
}

interface I1 extends I0 {
    int [] y = {x + 1, x + 2};
}

interface I2 extends I0 {
    int [] y = {x + 3, x + 4};
}

interface I3 extends I1, I2 {
    int z = I1.y[0];
    int t = I2.y[1];

}
public class TestAtributeAmbigue implements I3 {
    public static void main(String[] args) {
        System.out.println(x);
        System.out.println(z);
        System.out.println(t);
    }
}
