package View;

import Model.Jugadores;

import java.util.List;
import java.util.Scanner;

public class JugadoresView {
    private Scanner tcld = new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println("Menu Jugadores");
        System.out.println("1- Crear Jugadores");
        System.out.println("2- Mostrar Jugadores");
        System.out.println("3- Actualizar Jugadores");
        System.out.println("4- Eliminar Jugadores");
        System.out.println("5- Salir");
        System.out.println("Indicar una opción ❤:  ");
    }
    public void mostrarJugadores(List<Jugadores> jg){
        if(jg.isEmpty()){
            System.out.println("No hay jugadores");
        }else{
            jg.forEach(System.out::println);
        }
    }
    public Jugadores leerNuevoJugador(){
        System.out.println("nombre: ");
        String nombre = tcld.nextLine();
        System.out.println("nickname: ");
        String nick = tcld.nextLine();
        System.out.println("edad: ");
        int edad =Integer.parseInt(tcld.nextLine());
        Jugadores jg = new Jugadores ();
        jg.setNombre(nombre);
        jg.setNickname(nick);
        jg.setEdad(edad);
        return jg;
    }
    public Jugadores leerJugadorACtualizar(){
        System.out.println("Ingrese el ID del jugador a actualizar");
        int id = Integer.parseInt(tcld.nextLine());
        Jugadores jg = leerNuevoJugador();
        jg.setId_jugador(id);
        return jg;
    }
    public int leerIdEliminar(){
        System.out.println("Ingrese el id a eliminar: ");
        return Integer.parseInt(tcld.nextLine());
    }
    public int leerOpcion(){
        return Integer.parseInt(tcld.nextLine());
    }

}

