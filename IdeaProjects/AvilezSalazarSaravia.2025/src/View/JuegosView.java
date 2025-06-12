package View;
import Model.Juegos;
import java.util.*;

public class JuegosView {

    private Scanner teclado=new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println(" MENÚ DE JUEGOS ");
        System.out.println("1.- Listar Juegos:");
        System.out.println("2.- Crear Juegos");
        System.out.println("3.- Editar Juegos");
        System.out.println("4.- Eliminar Juegos");
        System.out.println("5.- Salir");
        System.out.println("Indique una opción 😊: ");

    }

    public void mostrarJuegos (List<Juegos> juegos){
        if( juegos.isEmpty()){
            System.out.println("No hay juegos");


        } else{
            juegos.forEach(System.out::println);
        }
    }

    public Juegos leerNuevoJuego() {
        System.out.println("Titulo: ");
        String titulo = teclado.nextLine();
        System.out.println("Genero: ");
        String genero = teclado.nextLine();
        System.out.println("Consola compatible:");
        String consola_compatible = teclado.nextLine();
        System.out.println("Precio:");
        int precio = Integer.parseInt(teclado.nextLine());
        Juegos jue= new Juegos();
        jue.setTitulo(titulo);
        jue.setGenero(genero);
        jue.setConsola_compatible(consola_compatible);
        jue.setPrecio(precio);
        return jue;
    }

    public Juegos leerJuegosActualizados(){
        System.out.println("Ingrese el ID del juego a actualizar: ");
        int id =Integer.parseInt(teclado.nextLine());
        Juegos juegos=leerNuevoJuego();
        juegos.setId_juego(id);
        return juegos;
    }

    public int leerIdEliminar(){
        System.out.println("Indique el ID a eliminar: ");
        return Integer.parseInt(teclado.nextLine());
    }

    public int leerOpcion(){
        return Integer.parseInt(teclado.nextLine());
    }
}