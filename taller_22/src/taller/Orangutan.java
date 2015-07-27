package taller;

public class Orangutan extends Mamifero {

    private int iq;
    private boolean enPareja;

    public Orangutan(String tipoPelaje, boolean enCelo, int iq, boolean enPareja) {
        super(tipoPelaje, enCelo);
        iq = iq;
        this.enPareja = enPareja;
    }

    public int getIq() {
        return iq;
    }

    public boolean isEnPareja() {
        return enPareja;
    }

}
