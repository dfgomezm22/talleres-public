package taller;

public class Serpiente extends Reptil {

    private boolean venenosa;
    private String comida;

    public Serpiente(boolean escamas, boolean carnivoro, boolean venenosa, String comida) {
        super(escamas, carnivoro);
        this.venenosa = venenosa;
        this.comida = comida;
    }

    public boolean isVenenosa() {
        return venenosa;
    }

    public String getComida() {
        return comida;
    }

}
