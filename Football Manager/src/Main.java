import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static HashMap<Integer, List<String[]>> baseDatos = new HashMap<>();
    private static final String ruta = "src/ArchivosTxt/";
    private static final Path[] rutas = {
            Paths.get(ruta +"mercat_fitxatges.txt"),
            Paths.get(ruta +"equiposDatos.txt")
    };

    public static void main(String[] args) {
        cargarDatos();

        int opcion = login();
        
        do {
            if  (!(opcion == 0)) {
                switch (menuOpciones(opcion)) {
                    case 1:
                        verClasificacionActual();
                        break;
                    case 2:
                        if (opcion == 1) {
                            darAltaEquipo();
                        } else {
                            gestionarMiEquipo();
                        }
                        break;
                    case 3:
                        if (opcion == 1) {
                            darAltaJugadorEntrenador();
                        } else {
                            consultarDatosEquipo();
                        }
                        break;
                    case 4:
                        if (opcion == 1) {
                            consultarDatosEquipo();
                        } else {
                            consultarDatosJugadorEquipo();
                        }
                        break;
                    case 5:
                        if (opcion == 1) {
                            consultarDatosJugadorEquipo();
                        } else {
                            transferirJugador();
                        }
                        break;
                    case 6:
                        if (opcion == 1) {
                            disputarNuevaLiga();
                        } else {
                            guardarDatosEquipos();
                        }
                        break;
                    case 7:
                        realizarSesionEntrenamientoMercado();
                        break;
                    case 8:
                        guardarDatosEquipos();
                        break;
                    case 0:
                        opcion = 0;
                        break;
                    default:
                        break;
                }
            }
        } while (opcion != 0);

        
        salir();
    }

    private static void realizarSesionEntrenamientoMercado() {
    }

    private static void guardarDatosEquipos() {
        for (int i = 0; i < rutas.length; i++) {
            try (BufferedWriter bw = Files.newBufferedWriter(rutas[i])) {
                
                List<String[]> listaActual = baseDatos.get(i);

                for (String[] fila : listaActual) {
                    String linea = String.join(";", fila);

                    bw.write(linea);
                    bw.newLine();
                }

                System.out.println("Archivo " + rutas[i].getFileName() + " actualizado.");

            } catch (IOException e) {
                System.out.println("Error al guardar en " + rutas[i] + ": " + e.getMessage());
            }
        }
    }

    private static void disputarNuevaLiga() {
    }

    private static void transferirJugador() {
    }

    private static void consultarDatosJugadorEquipo() {
    }

    private static void consultarDatosEquipo() {
    }

    private static void darAltaJugadorEntrenador() {
    }

    private static void gestionarMiEquipo() {
    }

    private static boolean existeEnBaseDatos(int key, int posicion,String nombre) {
        if (!baseDatos.containsKey(key)) return false;

        for (String[] fila : baseDatos.get(key)) {
            if (fila[posicion].equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    private static void darAltaEquipo() {
        boolean volver = false;
        do {
            String nombreEquipo, fecha = "", ciudad = "", estadio = "", presidenteClub = "";

            System.out.println("\n--- ALTA DE EQUIPO ---");
            System.out.println("Introduce el nombre del equipo (o '0' para volver):");
            nombreEquipo = sc.nextLine();

            if (nombreEquipo.equals("0")) {
                volver = true;
            } else {
                if (!existeEnBaseDatos(1, 0, nombreEquipo)) {
                    System.out.println("Introduce la fecha de fundación (ej: 10/12/2007):");
                    fecha = sc.nextLine();

                    System.out.println("Introduce la ciudad:");
                    ciudad = sc.nextLine();

                    System.out.println("¿Quieres introducir el nombre del estadio? 1. Si 2. No");
                    if (validarOpcion(1, 2) == 1) {
                        System.out.print("Nombre del estadio: ");
                        estadio = sc.nextLine();
                    }

                    System.out.println("¿Quieres introducir el presidente? 1. Si 2. No");
                    if (validarOpcion(1, 2) == 1) {
                        System.out.print("Nombre del presidente: ");
                        presidenteClub = sc.nextLine();
                    }

                    String[] nuevoEquipo = {nombreEquipo, fecha, ciudad, estadio, presidenteClub};
                    baseDatos.get(1).add(nuevoEquipo);

                    System.out.println("Equipo [" + nombreEquipo + "] dado de alta correctamente.");
                    volver = true;

                } else {
                    System.out.println("El equipo '" + nombreEquipo + "' ya está registrado.");
                }
            }
        } while (!volver);
    }

    private static void verClasificacionActual() {
    }

    private static void salir() {
        System.out.println("\n------ FOOTBALL MANAGER ------");
        System.out.println("\n\n\n¡Gracias por usar Football Manager by Borja D. & Miguel M.! Hasta pronto.");
        System.out.println("\n\n\n------ FOOTBALL MANAGER ------");
    }

    private static List<String> obtenerOpciones(int opcion) {
        List<String> opciones = new ArrayList<>();
        opciones.add("Ver clasificación de la liga actual");
        if (opcion == 1) {
            opciones.add("Dar de alta un equipo");
            opciones.add("Dar de alta un jugador/a o entrenador/a");
        } else {
            opciones.add("Gestionar mi equipo");
        }
        opciones.add("Consultar datos de equipo");
        opciones.add("Consultar datos de jugador/a de tal equipo");
        if (opcion == 1) {
            opciones.add("Disputar la nueva liga");
            opciones.add("Realizar sesion de entrenamiento (del mercado de fichajes)");
        } else {
            opciones.add("Transferir jugado/a");
        }
        opciones.add("Guardar datos de los equipos");
        return opciones;
    }

    private static int menuOpciones(int opcion) {
        List<String> opciones = obtenerOpciones(opcion);

        System.out.println("\n------ BIENVENIDO/A FOOTBALL MANAGER ------");
        System.out.println("Hola bienvenido/a al Football Manager by Borja D. & Miguel M.\n");
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + " - " + opciones.get(i));
        }
        System.out.println("0 - Salir");

        return validarOpcion(0,opciones.size());
    }

    private static int validarOpcion(int min, int max) {
        int opcion = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("\nElige una opción (" + min + "-" + max + "): ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();

                if (opcion >= min && opcion <= max) {
                    entradaValida = true;
                } else {
                    System.out.println("Opción no válida. Por favor, introduce un número entre (" + min + "-" + max + ")");
                }
            } else {
                System.out.println("¡Error! Debes introducir un número entero. Intenta de nuevo.");
                sc.nextLine();
            }
        }
        return opcion;
    }

    private static int login() {
        System.out.println("------ LOGIN FOOTBALL MANAGER ------");
        List<String> opciones = new ArrayList<>();
        opciones.add("admin");
        opciones.add("gestor de equipos");

        for (int i = 0; i < opciones.size() ; i++) {
            System.out.println(i + 1 + " - " + opciones.get(i));
        }
        System.out.println("0 - Salir");
        return validarOpcion(0,opciones.size());
    }

    private static void cargarDatos() {
        for (int i = 0; i < rutas.length; i++) {
            baseDatos.put(i, new ArrayList<String[]>());
        }

        for (int i = 0; i < rutas.length; i++) {
            try (BufferedReader br = Files.newBufferedReader(rutas[i])) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    baseDatos.get(i).add(linea.split(";"));
                }
                List<String[]> filas = baseDatos.get(i);

                if (!filas.isEmpty()) {
                    int totalFilas = filas.size();
                    int totalColumnas = filas.get(0).length;

                    System.out.println("Matriz creada de la key " + i + ": " + totalFilas + " filas x " + totalColumnas + " columnas.");
                } else {
                    System.out.println("La key " + i + " (archivo " + rutas[i].getFileName() + ") está vacía.");
                }
            } catch (IOException e) {
                System.out.println("Error leyendo el archivo " + rutas[i] + ": " + e.getMessage());
            }
        }
    }
}