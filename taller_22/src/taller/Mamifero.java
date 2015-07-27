package taller;

public class Mamifero extends Animal {

    private String tipoPelaje;

    private boolean enCelo;

    public Mamifero(String tipoPelaje, boolean enCelo) {
        super();
        this.tipoPelaje = tipoPelaje;
        this.enCelo = enCelo;
    }

    public boolean isEnCelo() {
        return enCelo;
    }

    public void setEnCelo(boolean enCelo) {
        this.enCelo = enCelo;
    }

    public String getTipoPelaje() {
        return tipoPelaje;
    }

}
