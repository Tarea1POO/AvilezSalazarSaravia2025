package View;
import Model.Jugadores;
import java.util.*;
public class JugadoresView {
    private Scanner teclado = new Scanner(System.in);
    public void mostrarMenu(){
        System.out.println(" 👾🍕 MENÚ DE JUGADORES 👾🍕 ");
        System.out.println("1.- Listar Jugadores");
        System.out.println("2.- Crear Jugador");
        System.out.println("3.- Editar Jugador");
        System.out.println("4.- Eliminar Jugador");
        System.out.println("5.- Salir");
        System.out.println("Indique una opción 😁: ");
    }
    public void mostrarJugadores (List<Jugadores> jugadores){
        if( jugadores.isEmpty()){
            System.out.println("No hay jugadores");


        } else{
            jugadores.forEach(System.out::println);
        }
    }
    public Jugadores leerNuevoJugador() {
        System.out.println("Nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Nickname: ");
        String nickName = teclado.nextLine();
        System.out.println("Edad:");
        int edad = Integer.parseInt(teclado.nextLine());
        Jugadores ju= new Jugadores();
        ju.setNombre(nombre);
        ju.setNickname(nickName);
        ju.setEdad(edad);
        return ju;
    }
    public Jugadores leerJugadoresActualizados(){
        System.out.println("Ingrese el ID del jugador a actualizar: ");
        int id =Integer.parseInt(teclado.nextLine());
        Jugadores jugador=leerNuevoJugador();
        jugador.setId_jugador(id);
        return jugador;
    }
    public int leerIdEliminar(){
        System.out.println("Indique el ID a eliminar: ");
        return Integer.parseInt(teclado.nextLine());
    }
    public int leerOpcion(){
        return Integer.parseInt(teclado.nextLine());
    }
}