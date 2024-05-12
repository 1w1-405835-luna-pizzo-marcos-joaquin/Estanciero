package Src.Model;

import Src.Model.ITarjeta;

public class Suerte implements ITarjeta {


    private String Descripcion;
    private int id_tipo;
    public Suerte(String descripcion, int id_tipo) {
        Descripcion = descripcion;
        this.id_tipo = id_tipo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }


    @Override
    public void Mezclar() {

    }
}