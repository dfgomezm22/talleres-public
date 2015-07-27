package taller;

public class Reptil extends Animal {

    private boolean escamas;
    private boolean carnivoro;

    public Reptil(boolean escamas, boolean carnivoro) {
        super();
        this.escamas = escamas;
        this.carnivoro = carnivoro;
    }

    public boolean isEscamas() {
        return escamas;
    }

    public boolean isCarnivoro() {
        return carnivoro;
    }

}
