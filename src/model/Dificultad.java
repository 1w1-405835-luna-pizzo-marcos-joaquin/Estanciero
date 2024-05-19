package src.model;

public class Dificultad {


    private int id_dificultad;

    private String descripcion;
    public Dificultad(int id_dificultad, String descripcion) {
        this.id_dificultad = id_dificultad;
        this.descripcion = descripcion;
    }

    public int getId_dificultad() {
        return id_dificultad;
    }

    public void setId_dificultad(int id_dificultad) {
        this.id_dificultad = id_dificultad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
