package View;

import Model.Consolas;
import Model.Controles;

import java.util.List;
import java.util.Scanner;

public class ConsolasView {
    private Scanner tcld = new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println("Menu Consolas");
        System.out.println("1- Crear Consolas");
        System.out.println("2- Mostrar Consolas");
        System.out.println("3- Actualizar Consolas");
        System.out.println("4- Eliminar Consolas");
        System.out.println("5- Salir");
        System.out.println("Indicar una opción ❤:  ");
    }
    public void mostrarConsolas(List<Consolas> consolas){
        if(consolas.isEmpty()){
            System.out.println("No hay jugadores");
        }else{
            consolas.forEach(System.out::println);
        }
    }
    public Consolas leerNuevoConsolas(){
        System.out.println("nombre: ");
        String nombre = tcld.nextLine();
        System.out.println("fabricante: ");
        String fabricante = tcld.nextLine();
        System.out.println("anio_lanzamiento: ");
        int anio = Integer.parseInt(tcld.nextLine());
        Consolas consolas = new Consolas ();
        consolas.setNombre(nombre);
        consolas.setFabricante(fabricante);
        consolas.setAnio_lanzamiento(anio);
        return consolas;
    }
    public Consolas leerConsolasACtualizar(){
        System.out.println("Ingrese el ID del controles a actualizar");
        int id = Integer.parseInt(tcld.nextLine());
        Consolas consolas = leerConsolasACtualizar();
        consolas.setId_consola(id);
        return consolas;
    }
    public int leerIdEliminar(){
        System.out.println("Ingrese el id a eliminar: ");
        return Integer.parseInt(tcld.nextLine());
    }
    public int leerOpcion(){
        return Integer.parseInt(tcld.nextLine());
    }
}
