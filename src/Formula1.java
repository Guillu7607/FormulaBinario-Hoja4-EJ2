import java.io.*;
import java.util.*;

public class Formula1 {

    static List<Piloto> pilotos = new ArrayList<>();
    static final String FICHERO = "pilotos_f1.dat";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n--- GESTIÓN F1 ---");
            System.out.println("1. Cargar pilotos");
            System.out.println("2. Mostrar pilotos");
            System.out.println("3. Añadir piloto");
            System.out.println("4. Buscar piloto");
            System.out.println("5. Guardar datos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> cargarPilotos();
                case 2 -> mostrarPilotos();
                case 3 -> añadirPiloto();
                case 4 -> buscarPiloto();
                case 5 -> guardarPilotos();
            }

        } while (opcion != 0);
    }

    // 1. Cargar pilotos
    public static void cargarPilotos() {

        pilotos.clear();

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FICHERO))) {

            while (true) {
                Piloto p = (Piloto) ois.readObject();
                pilotos.add(p);
            }

        } catch (EOFException e) {
            System.out.println("Pilotos cargados correctamente.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar fichero: " + e.getMessage());
        }
    }

    // 2. Mostrar pilotos
    public static void mostrarPilotos() {

        if (pilotos.isEmpty()) {
            System.out.println("No hay pilotos cargados.");
            return;
        }

        for (Piloto p : pilotos) {
            System.out.println(p);
        }
    }

    // 3. Añadir piloto
    public static void añadirPiloto() {

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        for (Piloto p : pilotos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Ya existe un piloto con ese nombre.");
                return;
            }
        }

        System.out.print("Escudería: ");
        String escuderia = sc.nextLine();

        System.out.print("Puntos: ");
        int puntos = sc.nextInt();
        sc.nextLine();

        pilotos.add(new Piloto(nombre, escuderia, puntos));
        System.out.println("Piloto añadido.");
    }

    // 4. Buscar piloto
    public static void buscarPiloto() {

        System.out.print("Nombre a buscar: ");
        String nombre = sc.nextLine();

        for (Piloto p : pilotos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Encontrado: " + p);
                return;
            }
        }

        System.out.println("Piloto no encontrado.");
    }

    // 5. Guardar datos
    public static void guardarPilotos() {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FICHERO))) {

            for (Piloto p : pilotos) {
                oos.writeObject(p);
            }

            System.out.println("Datos guardados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
}
