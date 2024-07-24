package com.Grupo2.Estanciero.src.models;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validadores {
    private Scanner scanner = new Scanner(System.in);
    private static final String YES_NO_REGEX = "[yYnN]";
    Letras letras = new Letras();

    public Validadores() {

    }

    /**
     * Este metodo valida que lo que se ingrese por consola sea un numero
     * y retorna el numero ingresado
     */
    public int validadorNumero() {
        boolean esValido = false;
        int input = 0;
        while (!esValido) {
            try {
                input = scanner.nextInt();
                esValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.next();
            }
        }
        return input;
    }


    /**
     * Este metodo valida que se ingrese por consola un numero que este entre dos
     * valores requeridos por parametros.
     */
    public int validadorEntre(int min, int may) {

        int input = validadorNumero();

        while (input < min || input > may) {
            System.out.println(STR."Valor invalido. Ingrese un valor entre \{min} y \{may}: ");
            input = scanner.nextInt();

        }
        return input;
    }

    public Boolean getYesNoAnswer(String YesNO) {
        String input = validadorYesNo(YesNO);
        Pattern pattern = Pattern.compile(YES_NO_REGEX);
        Boolean answer = null;
        if (pattern.matcher(input).matches()) {
            answer = input.equalsIgnoreCase("y");
        } else {
            letras.println("Valor Incorrecto escribir 'y' or 'n'");
        }
        return answer;
    }


    public String validadorYesNo(String input) {
        String upperCase = input.toUpperCase();
        if (!upperCase.equals("Y") && !upperCase.equals("N")) {
            do {
                System.out.println("Valor incorrecto, debe escribir 'y' o 'n'");
                upperCase = scanner.nextLine().toUpperCase();
            } while (!upperCase.equals("Y") && !upperCase.equals("N"));
        }
        return upperCase;

    }

    public Boolean validarExistaPropiedad(ArrayList<Propiedades> prop, int seleccion) {
        for (Propiedades propiedad : prop) {
            if (propiedad.getNroCasilla() == seleccion) {
                return true;
            }
        }
        return false;

    }

    public boolean seTienenTodasZonas(ArrayList<Propiedades> propTablero, ArrayList<Propiedades> propJugador, Propiedades propiedad) {
        int cantidadZonas = 0;
        int cantidadZonasPosesion = 0;
        for (Propiedades pTablero : propTablero) {
            if (pTablero.getProvincia().equals(propiedad.getProvincia())) {
                cantidadZonas++;
            }
        }
        for (Propiedades pJugador : propJugador) {
            if (pJugador.getProvincia().equals(propiedad.getProvincia())) {
                cantidadZonasPosesion++;
            }
        }
        return cantidadZonasPosesion == cantidadZonas;
    }
}
