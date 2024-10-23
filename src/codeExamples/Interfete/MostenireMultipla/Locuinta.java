package codeExamples.Interfete.MostenireMultipla;

public abstract class Locuinta {
    protected int volum = 1;
    private boolean on;

    public void porneste() {
        on = true;
    }

    public void opreste() {
        on = false;
    }

    public abstract void schimbaVolum(int diferenta);
}
