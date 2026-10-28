package Clases;

import java.time.LocalDate;

/**
 * Clase abstracta que representa a una persona dentro del juego.
 *
 * Aquí guardamos datos básicos como nombre, apellido, sueldo,
 * fecha de nacimiento y motivación.
 *
 * Las clases que hereden de Persona (como Jugador o Entrenador)
 * pueden añadir más cosas y acciones.
 *
 * Autor: Miguel
 * Fecha: 06/03/2026 12:25
 */
public abstract class Persona {

    protected String nombre;

    protected String apellido;


    protected double sueldo;


    protected LocalDate fechaNacimiento;

    protected double motivacion;


    public Persona(String nombre, String apellido, double sueldo, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.fechaNacimiento = fechaNacimiento;
        motivacion = 5;
    }

    public String getNombre() {
        return nombre;
    }


    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public double getSueldo() {
        return sueldo;
    }


    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }


    public double getMotivacion() {
        return motivacion;
    }


    public void setMotivacion(double motivacion) {
        this.motivacion = motivacion;
    }

    /**
     * Aquí definimos cómo entrena la persona.
     * Cada tipo de persona (jugador, entrenador...) debe decir
     * qué pasa cuando entrena.
     */
    public abstract void entrenar();
}