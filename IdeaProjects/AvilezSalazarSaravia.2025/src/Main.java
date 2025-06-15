import java.util.*;
import Controller.JugadoresController;
import Controller.JuegosController;
import Controller.ConsolasController;
import Controller.ControlesController;
public class Main{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String opcion;
        do {
            System.out.println(" ");
            System.out.println(" 🎮 MENU PRINCIPAL 🎮 ");
            System.out.println("1- Gestionar Jugadores");
            System.out.println("2- Gestionar Juegos");
            System.out.println("3- Gestionar Consolas");
            System.out.println("4- Gestionar Controles");
            System.out.println("5- Salir");
            System.out.print("Ingrese una opción:");
            opcion = teclado.next();
            //Según la opción se instancia el controlador correspondiente,
            //para llevar a cabo la operación de cada módulo
            switch (opcion.toLowerCase()) {
                case "1":
                    new JugadoresController().iniciar();
                    break;
                case "2":
                    new JuegosController().iniciar();
                    break;
                case "3":
                    new ConsolasController().iniciar();
                    break;
                case "4":
                    new ControlesController().iniciar();
                    break;
                case "5":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción invalida, ingrese una opción del [1-5]");
            }
        }while(!opcion.equalsIgnoreCase("5"));;
        System.out.println(" ");
    }
}





