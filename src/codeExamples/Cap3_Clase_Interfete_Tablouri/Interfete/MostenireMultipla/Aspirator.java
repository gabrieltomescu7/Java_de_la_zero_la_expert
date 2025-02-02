package codeExamples.Cap3_Clase_Interfete_Tablouri.Interfete.MostenireMultipla;

class Aspirator extends Locuinta implements DispozitiveElectronice {
    private int timp = 0;

    public void schimbaVolum(int diferenta) {
        volum = volum + diferenta;
    }
    public void setTimpFolosinta(int timp) {
        this.timp = timp;
    }
    public int getTimpFolosinta() {
        return timp;
    }
    public int getPutere() {
        return 500;
    }
    public int getVolum() {
        return volum;
    }
}
