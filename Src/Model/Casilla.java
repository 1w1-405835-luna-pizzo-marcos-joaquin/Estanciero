package Src.Model;

public class Casilla {


    private int num_casilla;
    private int tipo;
    private Propiedades propiedad;
    public Casilla(int num_casilla, int tipo, Propiedades propiedad) {
        this.num_casilla = num_casilla;
        this.tipo = tipo;
        this.propiedad = propiedad;
    }

    public int getNum_casilla() {
        return num_casilla;
    }

    public void setNum_casilla(int num_casilla) {
        this.num_casilla = num_casilla;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Propiedades getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedades propiedad) {
        this.propiedad = propiedad;

    }



}
