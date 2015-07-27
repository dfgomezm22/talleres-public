package taller;

public class Jaguar extends Mamifero {

    private int numeroManchas;

    private int numeroDientes;

    public Jaguar(int numeroManchas, int numeroDientes, String tipoPelaje, boolean enCelo) {
        super(tipoPelaje, enCelo);
        this.numeroManchas = numeroManchas;
        this.numeroDientes = numeroDientes;
    }

    public int getNumeroManchas() {
        return numeroManchas;
    }

    public int getNumeroDientes() {
        return numeroDientes;
    }

}
