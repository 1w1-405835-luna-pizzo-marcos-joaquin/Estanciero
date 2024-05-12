package Src.Model;

public class ModoDeJuego {

    private int id_modo;
    private String descripcion;

    public int getId_modo() {
        return id_modo;
    }

    public void setId_modo(int id_modo) {
        this.id_modo = id_modo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ModoDeJuego(int id_modo, String descripcion) {
        this.id_modo = id_modo;
        this.descripcion = descripcion;
    }





}
