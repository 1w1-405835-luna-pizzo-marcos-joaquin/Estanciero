package src.model;

public class Jugador {

    private int idJugador;
    private String nombre;
    private int dinero;

    private Propiedades propiedades;
    private Casilla casilla;
    private int capitalTotal;
    private boolean preso;

    private int turnosPreso;

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public Propiedades getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(Propiedades propiedades) {
        this.propiedades = propiedades;
    }

    public Casilla getCasilla() {
        return casilla;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    public int getCapitalTotal() {
        return capitalTotal;
    }

    public void setCapitalTotal(int capitalTotal) {
        this.capitalTotal = capitalTotal;
    }

    public boolean isPreso() {
        return preso;
    }

    public void setPreso(boolean preso) {
        this.preso = preso;
    }

    public int getTurnosPreso() {
        return turnosPreso;
    }

    public void setTurnosPreso(int turnosPreso) {
        this.turnosPreso = turnosPreso;
    }


    public Jugador(int idJugador, String nombre, int dinero, Propiedades propiedades, Casilla casilla, int capitalTotal, boolean preso, int turnosPreso) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.dinero = dinero;
        this.propiedades = propiedades;
        this.casilla = casilla;
        this.capitalTotal = capitalTotal;
        this.preso = preso;
        this.turnosPreso = turnosPreso;
    }
}
