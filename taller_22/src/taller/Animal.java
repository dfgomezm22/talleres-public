package taller;

public abstract class Animal {

    private String nombre;
    private String nombreCientífico;
    private boolean enPeligro;
    private int edad;
    private String habitat;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCientífico() {
        return nombreCientífico;
    }

    public void setNombreCientífico(String nombreCientífico) {
        this.nombreCientífico = nombreCientífico;
    }

    public boolean isEnPeligro() {
        return enPeligro;
    }

    public void setEnPeligro(boolean enPeligro) {
        this.enPeligro = enPeligro;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
