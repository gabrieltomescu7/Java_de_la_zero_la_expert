package codeExamples.Interfete.MostenireMultipla;
class TV extends Locuinta implements DispozitiveElectronice {
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
        return 100;
    }

    public int getVolum() {
        return volum;
    }
}
