package codeExamples.Interfete.SuprascriereMetode;

import javax.sound.midi.Soundbank;

class ExceptiaNoastraUnu extends Exception {
    ExceptiaNoastraUnu() {super();}
}

class ExceptiaNoastraDoi extends Exception {
    ExceptiaNoastraDoi() { super();}
}

interface I1 {
    int f(int x) throws ExceptiaNoastraUnu, ExceptiaNoastraDoi;
}

interface I2 extends I1 {
    int f(int x) throws ExceptiaNoastraDoi;
}

class C1 implements I1 {
    public int f(int x) throws ExceptiaNoastraUnu, ExceptiaNoastraDoi {
        if (x < 0) throw new ExceptiaNoastraUnu();
        else throw new ExceptiaNoastraDoi();
    }
}

class C2 implements I2 {
    public int f(int x) throws ExceptiaNoastraDoi {
        if (x < 0) throw new ExceptiaNoastraDoi();
        return x;
    }
}
public class TestSuprascriereMetode {
    public static void main(String[] args) {
        C1 obiectUnu = new C1();
        C2 obiectDoi = new C2();
        try {
            System.out.println(obiectDoi.f(2));
            System.out.println(obiectUnu.f(-2));
            System.out.println(obiectDoi.f(-2));
            System.out.println(obiectUnu.f(2));
        }
        catch (ExceptiaNoastraUnu e) {
            System.err.println("A aparut o exceptie: " + e);
        }
        catch (ExceptiaNoastraDoi e) {
            System.err.println("A aparut o exceptie: " + e);
        }
    }
}
