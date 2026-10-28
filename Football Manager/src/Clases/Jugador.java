package Clases;

import java.time.LocalDate;

/**
 * Clase que representa a un jugador dentro del juego.
 *
 * Esta clase hereda de Persona y añade cosas específicas de los jugadores:
 * su dorsal, posición en el campo y su calidad. También se pueden hacer
 * cosas como entrenar o cambiar de posición.
 *
 * Autor: Miguel
 * Fecha: 06/03/2026 12:30
 */
public class Jugador extends Persona {

    private int dorsal;

    private Posicion posicion;


    private double calidad;

    public Jugador(String nombre, String apellido, double sueldo, LocalDate fechaNacimiento,
                    int dorsal, Posicion posicion, double calidad) {
        super(nombre, apellido, sueldo, fechaNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.calidad = calidad;
    }

    public enum Posicion {
        POR, DEF, MIG, DAV
    }


    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }


    public Posicion getPosicion() {
        return posicion;
    }


    public double getCalidad() {
        return calidad;
    }

    /**
     * Cambia la posición del jugador y mejora un poquito su calidad.
     * @param nuevaPosicion la nueva posición en el campo
     */
    public void cambioDePosicion(Posicion nuevaPosicion) {
        this.posicion = nuevaPosicion;
        calidad = calidad * 1.05 + 1;
    }

    /**
     * Simula un entrenamiento del jugador.
     * Puede mejorar su calidad de manera aleatoria.
     */

    @Override
    public void entrenar() {

        motivacion = motivacion + 0.2;

    }


    @Override
    public String toString() {
        return "Jugador: " + getNombre() + " " + getApellido() +
                " | Dorsal: " + dorsal +
                " | Posicion: " + posicion +
                " | Calidad: " + calidad;
    }
}