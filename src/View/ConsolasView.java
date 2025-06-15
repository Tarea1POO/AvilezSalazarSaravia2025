package View;
import Model.Consolas;
import java.util.*;
public class ConsolasView {
    private Scanner teclado = new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println(" ");
        System.out.println(" 🎲🙃 MENÚ DE CONSOLAS 🙃🎲");
        System.out.println("1.- Listar Consola/s 📄");
        System.out.println("2.- Crear Consola/s 🔧");
        System.out.println("3.- Editar Consola/s 🛠️");
        System.out.println("4.- Eliminar Consola/s ❌");
        System.out.println("5.- Salir 🔑");
        System.out.print("Indicar una opción 😁:  ");
        System.out.print("");
    }

    public void mostrarConsolas(List<Consolas> consolas){
        if(consolas.isEmpty()){
            System.out.println("");
            System.out.println("-- No hay consolas registradas --");
        }else{
            consolas.forEach(System.out::println);
        }
    }

    public Consolas leerNuevaConsola(){
        System.out.println(" ");
        System.out.println("🎰 CREANDO UNA NUEVA CONSOLA 🎰");
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();
        while(!nombre.matches("[a-zA-Z]+")){
            System.out.println("⚠️ Nombre no válido, inténtelo de nuevo ⚠️");
            System.out.print("Nombre: ");
            nombre = teclado.nextLine();
        }

        System.out.print("Fabricante: ");
        String fabricante = teclado.nextLine();
        while(!fabricante.matches("[a-zA-Z]+")){
            System.out.println("⚠️ Nombre del fabricante no válido, inténtelo de nuevo ⚠️");
            System.out.print("Fabricante: ");
            fabricante = teclado.nextLine();
        }

        int anio_lanzamiento = -1;
        System.out.print("Año de lanzamiento:");
        String anio_lanzamientoS = teclado.nextLine();
        while(!anio_lanzamientoS.matches("\\d{1,4}")){
            System.out.println("⚠️ Año de lanzamiento inválido, inténtelo de nuevo ⚠️");
            System.out.print("Año de lanzamiento: ");
            anio_lanzamientoS = teclado.nextLine();
        }
        anio_lanzamiento = Integer.parseInt(anio_lanzamientoS);

        Consolas consolas = new Consolas();
        consolas.setNombre(nombre);
        consolas.setFabricante(fabricante);
        consolas.setAnio_lanzamiento(anio_lanzamiento);
        return consolas;
    }

    public Consolas leerConsolasActualizadas(){
        System.out.print("Ingrese el ID del control a actualizar: ");
        int id = Integer.parseInt(teclado.nextLine());
        Consolas consolas = leerConsolasActualizadas();
        consolas.setId_consola(id);
        return consolas;
    }

    public int leerIdEliminar(){
        System.out.print("Ingrese el ID del control a eliminar: ");
        return Integer.parseInt(teclado.nextLine());
    }

    public int leerOpcion(){
        return Integer.parseInt(teclado.nextLine());
    }
}
