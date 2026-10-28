package Clases;

/**
 * Clase que guarda las estadísticas de un equipo o jugador.
 *
 * Aquí se lleva la cuenta de puntos, partidos jugados,
 * goles a favor y en contra. También podemos actualizar
 * las estadísticas según gane, empate o pierda un partido.
 *
 * Autor: Borja
 * Fecha: 06/03/2026 11:00
 */
public class Estadisticas {

    private int puntos;

    private int partidosJugados;

    private int golesFavor;

    private int golesContra;


    public Estadisticas() {
        puntos = 0;
        partidosJugados = 0;
        golesFavor = 0;
        golesContra = 0;
    }

    public void sumarVictoria() {
        puntos += 3;
        partidosJugados++;
    }

    public void sumarEmpate() {
        puntos += 1;
        partidosJugados++;
    }


    public void sumarDerrota() {
        partidosJugados++;
    }

    public void actualizarGoles(int favor, int contra) {
        golesFavor += favor;
        golesContra += contra;
    }

    public int diferenciaGoles() {
        return golesFavor - golesContra;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public int getPuntos() {
        return puntos;
    }
}