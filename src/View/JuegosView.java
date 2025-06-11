package View;

import Model.Juegos;
import Model.Jugadores;

import java.util.List;
import java.util.Scanner;

public class JuegosView {
    private Scanner tcld = new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println("Menu Jugadores");
        System.out.println("1- Crear Juegos");
        System.out.println("2- Mostrar Juegos");
        System.out.println("3- Actualizar Juegos");
        System.out.println("4- Eliminar Juegos");
        System.out.println("5- Salir");
        System.out.println("Indicar una opción ❤:  ");
    }
    public void mostrarJuegos(List<Juegos> jg){
        if(jg.isEmpty()){
            System.out.println("No hay jugadores");
        }else{
            jg.forEach(System.out::println);
        }
    }
    public Juegos leerNuevoJuegos(){
        System.out.println("titulo: ");
        String titulo = tcld.nextLine();
        System.out.println("genero: ");
        String genero = tcld.nextLine();
        System.out.println("consola_compatible: ");
        String consola = tcld.nextLine();
        System.out.println("precio");
        int precio = Integer.parseInt(tcld.nextLine());
        Juegos jg = new Juegos ();
        jg.setTitulo(titulo);
        jg.setGenero(genero);
        jg.setConsola_compatible(consola);
        jg.setPrecio(precio);
        return jg;
    }
    public Juegos leerJuegosACtualizar(){
        System.out.println("Ingrese el ID del juego a actualizar");
        int id = Integer.parseInt(tcld.nextLine());
        Juegos jg = leerNuevoJuegos();
        jg.setId_juego(id);
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
