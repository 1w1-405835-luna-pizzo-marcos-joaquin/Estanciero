package com.Grupo2.Estanciero.src.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class BotConservador extends Jugador {
   private  int contador;
    private Validadores validador=new Validadores();
    public BotConservador() {
        super();
        contador = 0;
    }

    public BotConservador(String nom, int id, String tipo) {
        super(nom, id, tipo);
        contador = 0;
    }

    /**
     * Este metodo es para comprar propiedades
     * <p>
     * recibe por parametro la casilla actual del jugador y se fija si
     * el id de la provincia coincide con el id de la provincia de preferencia
     * del bot, o que el bot se pueda permitir comprarla de a cuerdo a sus preferencias
     * de compra
     * Luego valida que el bot tenga el dinero suficiente para comprarla y que
     * no tenga un dueño
     * -----METODO INCOMPLETO, FALTA TERMINARLO Y PERFECCIONARLO------
     */
    @Override
    public void comprar(Casilla casilla) {

        String provincia = casilla.getPropiedad().getProvincia().toLowerCase();

            /**Se valida que tenga dinero y que no tenga propietario la casilla*/
            if (getDinero() >= casilla.getPropiedad().getPrecio() &&
                    casilla.getPropiedad().getIdPropietrio() == 0) {
                /**Se valida que el nro de provincia coincida con el de preferencia*/
                if (provincia.equals("formosa")||provincia.equals("rio negro")||provincia.equals("salta")) {
                    //Se setea un propietario a la casilla
                    casilla.getPropiedad().setIdPropietrio(getIdJugador());
                    //se resta al dinero total el valor de la compra
                    setDinero(getDinero() - casilla.getPropiedad().getPrecio());
                    //se setea el valor del capital total
                    setCapitalTotal(getCapitalTotal() + casilla.getPropiedad().getPrecioVenta());
                    setContador(getContador() + 1);
                    getPropiedades().add(casilla.getPropiedad());
                    System.out.println(STR."El bot conservador compro la zona:\{casilla.getPropiedad().getZona()} de la provincia \{casilla.getPropiedad().getProvincia()}");

                } else if (getContador() == 4) {
                    //Se setea un propietario a la casilla
                    casilla.getPropiedad().setIdPropietrio(getIdJugador());
                    //se resta al dinero total el valor de la compra
                    setDinero(getDinero() - casilla.getPropiedad().getPrecio());
                    //se setea el valor del capital total
                    setCapitalTotal(getCapitalTotal() + casilla.getPropiedad().getPrecioVenta());
                    getPropiedades().add(casilla.getPropiedad());
                    System.out.println(STR."El bot conservador compro la zona:\{casilla.getPropiedad().getZona()} de la provincia \{casilla.getPropiedad().getProvincia()}");
                    setContador(0);
                }
            }


    }

    //Construirá mejoras solo cuando el costo de la construcción no sobrepase el 30% de su dinero en cuenta.
    @Override
    public void construir(ArrayList<Propiedades> pTablero, ArrayList<Casilla> lista){

        for (Propiedades prop:getPropiedades()) {

            if (prop.getPrecioMejora() < 0.3 * getDinero()) {
                if (validador.seTienenTodasZonas(pTablero,getPropiedades(),prop)&&prop.getCantidadChacras()<4){
                    prop.setCantidadChacras(prop.getCantidadChacras() + 1);

                    //Sacamos la suma de dinero de la cuenta
                    setDinero(getDinero() - prop.getPrecioMejora());

                    //Incrementamos el precio de venta de la propiedad
                    prop.setPrecioVenta(prop.getPrecioVenta() + (prop.getPrecioMejora() / 2));

                    //Aumentamos el valor del alquiler

                    int incremento = prop.getAlquiler() * (1 / prop.getCantidadChacras());
                    prop.setAlquiler(prop.getAlquiler() + incremento);

                    setCapitalTotal(getCapitalTotal() - prop.getPrecioMejora()/2);
                    System.out.println(STR."El jugador \{getNombre()} Mejoro \{prop.getProvincia()} \{prop.getZona()}");
                }
            }
        }
    }


}
