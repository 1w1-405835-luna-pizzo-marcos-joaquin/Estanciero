package src.model;

public class Provincia {

    private int id;
    private String nombre;
    private Zona zona;
    public Provincia(int id, String nombre, Zona zona) {
        this.id = id;
        this.nombre = nombre;
        this.zona = zona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }


}
