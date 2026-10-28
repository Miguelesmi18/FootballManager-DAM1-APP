package Clases;

import java.time.LocalDate;

/**
 * Clase que representa a un entrenador dentro del juego.
 *
 * Hereda de Persona y añade cosas propias de los entrenadores:
 * cuántos torneos ha ganado y si es seleccionador nacional o no.
 * También puede entrenar y aumentar su sueldo.
 *
 * Autor: Miguel
 * Fecha: 06/03/2026 12:59
 */
public class Entrenador extends Persona {

    private int torneosGanados;

    private boolean seleccionador;

    public Entrenador(String nombre, String apellido, double sueldo, LocalDate fechaNacimiento, double motivacion,
                      int torneosGanados, boolean seleccionador) {
        super(nombre, apellido, sueldo, fechaNacimiento);
        this.torneosGanados = torneosGanados;
        this.seleccionador = seleccionador;
    }


    public void incrementarSueldo() {
        setSueldo(getSueldo() + 500);
    }


    public int getTorneosGanados() {
        return torneosGanados;
    }


    public boolean isSeleccionadorNacional() {
        return seleccionador;
    }

    /**
     * Simula un entrenamiento del entrenador.
     * Si es seleccionador, se motiva un poquito más.
     */
    @Override
    public void entrenar() {
        motivacion = motivacion + 0.1;
    }

    @Override
    public String toString() {
        return "Entrenador: " + getNombre() + " " + getApellido() +
                " | Torneos ganados: " + torneosGanados +
                " | Seleccionador: " + seleccionador;
    }
}