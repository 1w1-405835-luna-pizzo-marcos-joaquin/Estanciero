package com.Grupo2.Estanciero.src.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

@Getter
@Setter
public class BotAgresivo extends Jugador {

    private int contador;
    private Validadores validador = new Validadores();

    public void setContador(int contador) {
        this.contador = contador;
    }

    public BotAgresivo() {
        super();
    }

    public BotAgresivo(String nom, int id, String tipo) {
        super(nom, id, tipo);
        contador = 0;
    }

    @Override
    public void comprar(Casilla casilla) {
        String provincia = casilla.getPropiedad().getProvincia().toLowerCase();

        /**Se valida que tenga dinero y que no tenga propietario la casilla*/
        if (getDinero() >= casilla.getPropiedad().getPrecio() &&
                casilla.getPropiedad().getIdPropietrio() == 0) {
            /**Se valida que el nro de provincia coincida con el de preferencia*/
            if (provincia.equals("tucuman") || provincia.equals("cordoba") || provincia.equals("buenos aires")) {
                //Se setea un propietario a la casilla
                casilla.getPropiedad().setIdPropietrio(getIdJugador());
                //se resta al dinero total el valor de la compra
                setDinero(getDinero() - casilla.getPropiedad().getPrecio());
                //se setea el valor del capital total
                setCapitalTotal(getCapitalTotal() + casilla.getPropiedad().getPrecioVenta());
                setContador(getContador() + 1);
                getPropiedades().add(casilla.getPropiedad());
                System.out.println(STR."El bot agresivo compro la zona:\{casilla.getPropiedad().getZona()} de la provincia \{casilla.getPropiedad().getProvincia()}");
            }

            //se valida que la casilla sea del tipo ferrocarril..
            else if (provincia.equals("ferrocarril")) {
                //Se setea un propietario a la casilla.
                casilla.getPropiedad().setIdPropietrio(getIdJugador());
                //se resta al dinero total el valor de la compra
                setDinero(getDinero() - casilla.getPropiedad().getPrecio());
                //se setea el valor del capital total
                setCapitalTotal(getCapitalTotal() + casilla.getPropiedad().getPrecioVenta());
                setContador(getContador() + 1);
                getPropiedades().add(casilla.getPropiedad());
                System.out.println(STR."El bot agresivo compro el ferrocarril: \{casilla.getPropiedad().getZona()}");
            }

            //se valida que la casilla sea del tipo compania
            else if (provincia.equals("compania")) {
                //Se setea un propietario a la casilla
                casilla.getPropiedad().setIdPropietrio(getIdJugador());
                //se resta al dinero total el valor de la compra
                setDinero(getDinero() - casilla.getPropiedad().getPrecio());
                //se setea el valor del capital total
                setCapitalTotal(getCapitalTotal() + casilla.getPropiedad().getPrecioVenta());
                setContador(getContador() + 1);
                getPropiedades().add(casilla.getPropiedad());
                System.out.println(STR."El bot agresivo compro la casilla : \{casilla.getPropiedad().getZona()}");

            }
        }

    }

    @Override
    public void construir(ArrayList<Propiedades> pTablero, ArrayList<Casilla> lista) {
        for (Propiedades prop : getPropiedades()) {
            if (getDinero() >= prop.getPrecioMejora() && validador.seTienenTodasZonas(pTablero, getPropiedades(), prop)) {
                if (prop.getCantidadChacras() < 4) {
                    prop.setCantidadChacras(prop.getCantidadChacras() + 1);

                    //Sacamos la suma de dinero de la cuenta
                    setDinero(getDinero() - prop.getPrecioMejora());

                    //Incrementamos el precio de venta de la propiedad
                    prop.setPrecioVenta(prop.getPrecioVenta() + (prop.getPrecioMejora() / 2));

                    //Aumentamos el valor del alquiler inversamente proporcional a la cantidad de chacras

                    int incremento = prop.getAlquiler() * (1 / prop.getCantidadChacras());
                    prop.setAlquiler(prop.getAlquiler() + incremento);

                    setCapitalTotal(getCapitalTotal() - prop.getPrecioMejora() / 2);
                    System.out.println(STR."El jugador \{getNombre()} Mejoro \{prop.getProvincia()} \{prop.getZona()}");

                }
            }
        }
    }
}