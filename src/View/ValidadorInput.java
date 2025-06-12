package View;
import java.util.Scanner;
    public class ValidadorInput {

        public static String leerTextoNoVacio(Scanner sc, String mensaje) {
            String texto;
            while (true) {
                System.out.print(mensaje);
                texto = sc.nextLine().trim();
                if (!texto.isEmpty()) return texto;
                System.out.println("❌ Este campo no puede estar vacío.");
            }
        }

        public static int leerEnteroPositivo(Scanner sc, String mensaje) {
            int valor;
            while (true) {
                System.out.print(mensaje);
                try {
                    valor = Integer.parseInt(sc.nextLine());
                    if (valor > 0) return valor;
                    System.out.println("❌ Debe ingresar un número mayor a 0.");
                } catch (NumberFormatException e) {
                    System.out.println("❌ Entrada inválida. Ingrese un número entero.");
                }
            }
        }

        public static int leerOpcionMenu(Scanner sc, String mensaje, int maxOpcion) {
            int opcion;
            while (true) {
                System.out.print(mensaje);
                try {
                    opcion = Integer.parseInt(sc.nextLine());
                    if (opcion >= 1 && opcion <= maxOpcion)
                        return opcion;
                    System.out.println("❌ Opción fuera de rango.");
                } catch (NumberFormatException e) {
                    System.out.println("❌ Debe ingresar un número válido.");
                }
            }
        }
    }