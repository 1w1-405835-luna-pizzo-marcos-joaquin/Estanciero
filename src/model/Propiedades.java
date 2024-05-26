package src.model;

public class Propiedades {
    private int idProvincia;
    private int idPropietrio;
    private int nroCasilla;
    private int precio;
    private int precioMejora;
    private int cantidadChacras;
    private int alquiler;
    private Provincia provincia;


    public Propiedades(int idProvincia, int idPropietrio, int nroCasilla, int precio, int precioMejora, int cantidadChacras, int alquiler, Provincia provincia) {
        this.idProvincia = idProvincia;
        this.idPropietrio = idPropietrio;
        this.nroCasilla = nroCasilla;
        this.precio = precio;
        this.precioMejora = precioMejora;
        this.cantidadChacras = cantidadChacras;
        this.alquiler = alquiler;
        this.provincia = provincia;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public int getIdPropietrio() {
        return idPropietrio;
    }

    public void setIdPropietrio(int idPropietrio) {
        this.idPropietrio = idPropietrio;
    }

    public int getNroCasilla() {
        return nroCasilla;
    }

    public void setNroCasilla(int nroCasilla) {
        this.nroCasilla = nroCasilla;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPrecioMejora() {
        return precioMejora;
    }

    public void setPrecioMejora(int precioMejora) {
        this.precioMejora = precioMejora;
    }

    public int getCantidadChacras() {
        return cantidadChacras;
    }

    public void setCantidadChacras(int cantidadChacras) {
        this.cantidadChacras = cantidadChacras;
    }

    public int getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(int alquiler) {
        this.alquiler = alquiler;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }



}
