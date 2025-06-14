package View;
import Model.Consolas;
import java.util.*;

public class ConsolasView {

    private Scanner teclado=new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println(" MENÚ DE CONSOLAS ");
        System.out.println("1.- Listar Consolas 🗒️ ");
        System.out.println("2.- Crear Consola 🔧");
        System.out.println("3.- Actualizar Consola 🛠️");
        System.out.println("4.- Eliminar Consola ❌ ");
        System.out.println("5.- Salir 🔑 ");
        System.out.print("Indique una opción 😊: ");

    }

    public void mostrarConsolas (List<Consolas> Consolas){
        if( Consolas.isEmpty()){
            System.out.println("No hay consolas");


        } else{
            Consolas.forEach(System.out::println);
        }
    }

    public Consolas leerNuevaConsola() {
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();
        System.out.print("Fabricante: ");
        String fabricante = teclado.nextLine();
        System.out.print("Año de lanzamiento:");
        int anio_lanzamiento = Integer.parseInt(teclado.nextLine());
        Consolas co= new Consolas();
        co.setNombre(nombre);
        co.setFabricante(fabricante);
        co.setAnio_lanzamiento(anio_lanzamiento);
        return co;
    }

    public Consolas leerConsolasActualizadas(){
        System.out.print("Ingrese el ID de la consola a actualizar: ");
        int id =Integer.parseInt(teclado.nextLine());
        Consolas consolas=leerNuevaConsola();
        consolas.setId_consola(id);
        return consolas;
    }

    public int leerIdEliminar(){
        System.out.print("Indique el ID a eliminar: ");
        return Integer.parseInt(teclado.nextLine());
    }

    public int leerOpcion(){
        return Integer.parseInt(teclado.nextLine());
    }
}
