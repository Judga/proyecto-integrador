import java.util.*;

public class ReservaComputadora {
    // Definimos las aulas y las computadoras disponibles
    private static Map<String, List<String>> aulas = new HashMap<>();
    private static Map<String, Map<String, String>> reservas = new HashMap<>();

    public static void main(String[] args) {
        // Inicializamos las aulas con las computadoras disponibles
        aulas.put("Aula 1", Arrays.asList("Compu 1", "Compu 2", "Compu 3"));
        aulas.put("Aula 2", Arrays.asList("Compu 1", "Compu 2"));

        Scanner scanner = new Scanner(System.in);

        // Escoger aula
        System.out.println("Seleccione un aula:");
        List<String> nombresAulas = new ArrayList<>(aulas.keySet());
        for (int i = 0; i < nombresAulas.size(); i++) {
            System.out.println((i + 1) + ". " + nombresAulas.get(i));
        }
        int aulaSeleccionada = scanner.nextInt();
        String nombreAula = nombresAulas.get(aulaSeleccionada - 1);

        // Escoger computadora
        System.out.println("Seleccione una computadora en " + nombreAula + ":");
        List<String> computadoras = aulas.get(nombreAula);
        for (int i = 0; i < computadoras.size(); i++) {
            System.out.println((i + 1) + ". " + computadoras.get(i));
        }
        int computadoraSeleccionada = scanner.nextInt();
        String nombreComputadora = computadoras.get(computadoraSeleccionada - 1);

        // Verificar disponibilidad
        if (reservas.containsKey(nombreAula) && reservas.get(nombreAula).containsKey(nombreComputadora)) {
            System.out.println("Computadora no disponible.");
        } else {
            // Seleccionar fecha y hora
            scanner.nextLine(); // Limpiar el buffer
            System.out.println("Ingrese la fecha de la reserva (dd/MM/yyyy):");
            String fecha = scanner.nextLine();
            System.out.println("Ingrese la hora de la reserva (HH:mm):");
            String hora = scanner.nextLine();

            // Confirmar reserva
            System.out.println("Confirma la reserva? (si/no):");
            String confirmacion = scanner.nextLine();
            if (confirmacion.equalsIgnoreCase("si")) {
                if (!reservas.containsKey(nombreAula)) {
                    reservas.put(nombreAula, new HashMap<>());
                }
                reservas.get(nombreAula).put(nombreComputadora, fecha + " " + hora);
                System.out.println("Reserva confirmada para " + nombreComputadora + " en " + nombreAula + " el " + fecha + " a las " + hora);
            } else {
                System.out.println("Reserva cancelada.");
            }
        }

        // Finalizar la consola
        System.out.println("Finalizando la consola...");
        scanner.close();
    }
}
