package Clases;
import java.util.ArrayList;

public class Lliga {

    private String nombre;
    private int numeroEquipos;
    private ArrayList<Equipo> equipos;

    public Lliga(String nombre, int numeroEquipos) {

        this.nombre = nombre;
        this.numeroEquipos = numeroEquipos;

        equipos = new ArrayList<>();

    }

    public Lliga() {
    }

    public void agregarEquipo(Equipo equipo) {

        if (equipos.size() < numeroEquipos) {

            equipos.add(equipo);

            System.out.println("Equipo añadido: " + equipo.getNombre());

        } else {

            System.out.println("La liga ya está llena");

        }

    }

    public void mostrarClasificacion() {

        System.out.println("Clasificación de la liga: " + nombre);

        for (Equipo e : equipos) {

            System.out.println(
                    e.getNombre() +
                            " - Puntos: " +
                            e.getEstadisticas().getPuntos()
            );

        }

    }

    public void eliminarJugador(Jugador jugador) {

        for (Equipo e : equipos) {

            e.eliminarJugador(jugador);

        }

    }

    public Equipo equipoMasGolesFavor() {

        if (equipos.size() == 0) return null;

        Equipo mejor = equipos.get(0);

        for (Equipo e : equipos) {

            if (e.getEstadisticas().getGolesFavor() >
                    mejor.getEstadisticas().getGolesFavor()) {

                mejor = e;

            }

        }

        return mejor;

    }

    public Equipo equipoMasGolesContra() {

        if (equipos.size() == 0) {
            return null;
        }

        Equipo peor = equipos.get(0);

        for (Equipo e : equipos) {

            if (e.getEstadisticas().getGolesContra() >
                    peor.getEstadisticas().getGolesContra()) {

                peor = e;

            }

        }

        return peor;

    }

    public void disputarLiga() {

        for (int i = 0; i < equipos.size(); i++) {

            for (int j = i + 1; j < equipos.size(); j++) {

                Equipo local = equipos.get(i);
                Equipo visitante = equipos.get(j);

                int golesLocal = (int)(Math.random() * 5);
                int golesVisitante = (int)(Math.random() * 5);

                local.getEstadisticas().actualizarGoles(golesLocal, golesVisitante);
                visitante.getEstadisticas().actualizarGoles(golesVisitante, golesLocal);

                if (golesLocal > golesVisitante) {

                    local.getEstadisticas().sumarVictoria();
                    visitante.getEstadisticas().sumarDerrota();

                } else if (golesLocal < golesVisitante) {

                    visitante.getEstadisticas().sumarVictoria();
                    local.getEstadisticas().sumarDerrota();

                } else {

                    local.getEstadisticas().sumarEmpate();
                    visitante.getEstadisticas().sumarEmpate();

                }

            }

        }

    }
}