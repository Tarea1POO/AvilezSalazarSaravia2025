package View;

import Model.Controles;
import Model.Juegos;

import java.util.List;
import java.util.Scanner;

public class ControlesView {
    private Scanner tcld = new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println("Menu Controles");
        System.out.println("1- Crear Controles");
        System.out.println("2- Mostrar Controles");
        System.out.println("3- Actualizar Controles");
        System.out.println("4- Eliminar Controles");
        System.out.println("5- Salir");
        System.out.println("Indicar una opción ❤:  ");
    }
    public void mostrarControles(List<Controles> controles){
        if(controles.isEmpty()){
            System.out.println("No hay jugadores");
        }else{
            controles.forEach(System.out::println);
        }
    }
    public Controles leerNuevoControles(){
        System.out.println("tipo: ");
        String tipo = tcld.nextLine();
        System.out.println("consola_compatible: ");
        String consola = tcld.nextLine();
        System.out.println("estado: ");
        String estado = tcld.nextLine();
        Controles controles = new Controles ();
        controles.setTipo(tipo);
        controles.setConsola_compatible(consola);
        controles.setEstado(estado);
        return controles;
    }
    public Controles leerControlesACtualizar(){
        System.out.println("Ingrese el ID del controles a actualizar");
        int id = Integer.parseInt(tcld.nextLine());
        Controles controles = leerNuevoControles();
        controles.setId_control(id);
        return controles;
    }
    public int leerIdEliminar(){
        System.out.println("Ingrese el id a eliminar: ");
        return Integer.parseInt(tcld.nextLine());
    }
    public int leerOpcion(){
        return Integer.parseInt(tcld.nextLine());
    }
}
