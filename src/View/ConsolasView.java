package View;
import Model.Consolas;
import java.util.*;
public class ConsolasView {
    private Scanner teclado = new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println(" ");
        System.out.println(" 🎲🙃 MENÚ DE CONSOLAS 🙃🎲");
        System.out.println("1- Crear Consola 📄");
        System.out.println("2- Editar Consola 🔧");
        System.out.println("3- Actualizar Consola 🛠️");
        System.out.println("4- Eliminar Consola ❌");
        System.out.println("5- Salir 🔑");
        System.out.print("Indicar una opción 😁:  ");
    }

    public void mostrarConsolas(List<Consolas> consolas){
        if(consolas.isEmpty()){
            System.out.println("No hay consolas");
        }else{
            consolas.forEach(System.out::println);
        }
    }

    public Consolas leerNuevaConsola(){
        System.out.println("nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("fabricante: ");
        String fabricante = teclado.nextLine();
        System.out.println("anio_lanzamiento: ");
        int anio = Integer.parseInt(teclado.nextLine());
        Consolas consolas = new Consolas ();
        consolas.setNombre(nombre);
        consolas.setFabricante(fabricante);
        consolas.setAnio_lanzamiento(anio);
        return consolas;
    }

    public Consolas leerConsolasActualizadas(){
        System.out.println("Ingrese el ID del controles a actualizar");
        int id = Integer.parseInt(teclado.nextLine());
        Consolas consolas = leerConsolasActualizadas();
        consolas.setId_consola(id);
        return consolas;
    }

    public int leerIdEliminar(){
        System.out.println("Ingrese el id a eliminar: ");
        return Integer.parseInt(teclado.nextLine());
    }

    public int leerOpcion(){
        return Integer.parseInt(teclado.nextLine());
    }
}
