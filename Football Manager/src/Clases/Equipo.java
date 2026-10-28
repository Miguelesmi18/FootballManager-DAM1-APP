package Clases;

import java.util.ArrayList;

/**
 * Clase que representa a un equipo de fútbol dentro del juego.
 *
 * Aquí guardamos datos del equipo como nombre, ciudad, presidente,
 * estadio, entrenador y la lista de jugadores.
 * También podemos fichar, eliminar o buscar jugadores, y
 * chequear si un dorsal está disponible.
 *
 * Autor: Borja
 * Fecha: 06/03/2026 13:40
 */
public class Equipo {

    private String nombre;
    private int anioFundacion;
    private String ciudad;
    private String nombrePresidente;
    private String nombreEstadio;
    private ArrayList<Jugador> jugadores;
    private Estadisticas estadisticas;

    public Equipo() {
    }

    public String getNombre() {
        return nombre;
    }

    public Equipo(String nombre, int anioFundacion, String nombrePresidente, String ciudad, String nombreEstadio) {
        this.nombre = nombre;
        this.anioFundacion = anioFundacion;
        this.nombrePresidente = nombrePresidente;
        this.ciudad = ciudad;
        this.nombreEstadio = nombreEstadio;
        jugadores = new ArrayList<>();
        estadisticas = new Estadisticas();
    }

    public void ficharJugador(Jugador j) {
        jugadores.add(j);
    }

    public Estadisticas getEstadisticas() {
        return estadisticas;
    }

    public void eliminarJugador(Jugador j) {
        jugadores.remove(j);
    }

    /**
     * Busca un jugador por nombre y dorsal.
     * @param nombre nombre del jugador
     * @param dorsal dorsal del jugador
     * @return el jugador si lo encuentra, o null si no
     */
    public Jugador buscarJugador(String nombre, int dorsal) {
        for (Jugador j : jugadores) {
            if (j.getNombre().equals(nombre) && j.getDorsal() == dorsal) {
                return j;
            }
        }
        return null;
    }

    /**
     * Comprueba si un dorsal está disponible en el equipo.
     * @param dorsal número de dorsal
     * @return true si está libre, false si ya hay alguien con ese dorsal
     */
    public boolean siDorsalDisponible(int dorsal) {
        for (Jugador j : jugadores) {
            if (j.getDorsal() == dorsal) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Equipo" + nombre +
                ", anioFundacion=" + anioFundacion +
                ", ciudad='" + ciudad +
                ", nombrePresidente='" + nombrePresidente + '\'' +
                ", nombreEstadio='" + nombreEstadio + '\'' +
                " , numero jugadores=" + jugadores.size();
    }
}