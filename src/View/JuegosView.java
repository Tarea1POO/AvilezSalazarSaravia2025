package View;
import Model.Juegos;
import java.util.*;
public class JuegosView {
    private Scanner teclado = new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println(" ");
        System.out.println(" 🕹️♦️ MENÚ DE JUEGOS ♦️🕹️ ");
        System.out.println("1.- Listar Juegos 🗒️");
        System.out.println("2.- Crear Juegos 🔧");
        System.out.println("3.- Editar Juegos 🛠️");
        System.out.println("4.- Eliminar Juegos ❌");
        System.out.println("5.- Salir 🔑");
        System.out.print("Indique una opción 😁: ");
    }

    public void mostrarJuegos (List<Juegos> juegos){
        if( juegos.isEmpty()){
            System.out.println("");
            System.out.println("-- No hay juegos registrados --");
        } else{
            juegos.forEach(System.out::println);
        }
    }

    public Juegos leerNuevoJuego(){
        System.out.println(" ");
        System.out.println("🎯 CREANDO UN NUEVO JUEGO 🎯");

        System.out.println("Titulo: ");
        String titulo = teclado.nextLine();
        while(!titulo.matches("[a-zA-Z]+")){
            System.out.println("⚠️ Título no válido, inténtelo de nuevo ⚠️");
            System.out.println("Título: ");
            titulo = teclado.nextLine();
        }

        System.out.println("Género: ");
        String genero = teclado.nextLine();
        while(!genero.matches("[a-zA-Z]+")){
            System.out.println("⚠️ Género no válido, inténtelo de nuevo ⚠️");
            System.out.println("Género: ");
            genero = teclado.nextLine();
        }

        System.out.println("Consola compatible:");
        String consola_compatible = teclado.nextLine();
        while(!consola_compatible.matches("[a-zA-Z]+")){
            System.out.println("⚠️ Consola no compatible, inténtelo de nuevo ⚠️");
            System.out.println("");
            System.out.println("Consola compatible: ");
            consola_compatible = teclado.nextLine();
        }

        int precio = 0;
        System.out.println("Precio:");
        String precioS = teclado.nextLine();
        while(!precioS.matches("\\d{1,6}")){
            System.out.println("⚠️ Precio no válido, inténtelo de nuevo ⚠️");
            System.out.println("");
            System.out.print("Precio: ");
            precioS = teclado.nextLine();
        }
        precio = Integer.parseInt(precioS);

        Juegos jue= new Juegos();
        jue.setTitulo(titulo);
        jue.setGenero(genero);
        jue.setConsola_compatible(consola_compatible);
        jue.setId_juego(precio);
        return jue;
    }

    public Juegos leerJuegosActualizados(){
        System.out.println(" ");
        System.out.println("Ingrese el ID del juego a actualizar: ");
        int id =Integer.parseInt(teclado.nextLine());
        Juegos juegos=leerNuevoJuego();
        juegos.setId_juego(id);
        return juegos;
    }

    public int leerIdEliminar(){
        System.out.println(" ");
        System.out.println("Ingrese el ID a eliminar: ");
        return Integer.parseInt(teclado.nextLine());
    }

    public int leerOpcion(){
        return Integer.parseInt(teclado.nextLine());
    }
}