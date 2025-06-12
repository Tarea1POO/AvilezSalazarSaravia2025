import java.util.*;
import Controller.JugadoresController;
import Controller.JuegosController;
import Controller.ConsolasController;
import Controller.ControlesController;
import Model.Jugadores;
import Model.Juegos;
import Model.Consolas;
import Model.Controles;
import View.JugadoresView;
import View.JuegosView;
import View.ConsolasView;
import View.ControlesView;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("🎮🕹️ MENÚ PRINCIPAL 🕹️🎮");
            System.out.println("1.- Gestionar Jugadores");
            System.out.println("2.- Gestionar Juegos");
            System.out.println("3.- Gestionar Consolas");
            System.out.println("4.- Gestionar Controles");
            System.out.println("5.- Salir");
            System.out.println("Indique una opción: ");
            opcion = teclado.nextInt();

            switch (opcion){
                case 1:
                    new JugadoresController().iniciar();
                    break;
                case 2:
                    new JuegosController().iniciar();
                    break;
                case 3:
                    new ConsolasController().iniciar();
                    break;
                case 4:
                    new ControlesController().iniciar();
                    break;
                case 5:
                    System.out.println("Saliendo del programa!....😜");
                default:
                    System.out.println("Opción inválida, ingrese una opción del [1 al 5] 😒");
            }
        }while(opcion!=5);
    }
}