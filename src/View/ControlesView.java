package View;
import Model.Controles;
import java.util.*;
public class ControlesView {
    private Scanner teclado = new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println(" ");
        System.out.println(" 🎮😋 MENÚ DE CONTROLES 🎮😋");
        System.out.println("1.- Listar Control/es 📄");
        System.out.println("2.- Crear Control/es 🔧");
        System.out.println("3.- Editar Control/es 🛠️");
        System.out.println("4.- Eliminar Control/es ❌");
        System.out.println("5.- Salir 🔑");
        System.out.print("Indique una opción 😁: ");
        System.out.print("");
    }

    public void mostrarControles (List<Controles> controles){
        if( controles.isEmpty()){
            System.out.println("");
            System.out.println("-- No hay controles registrados --");
        } else{
            controles.forEach(System.out::println);
        }
    }

    public Controles leerNuevoControl(){
        System.out.println(" ");
        System.out.println("🎮 CREANDO UN NUEVO CONTROL 🎮");
        System.out.print("Tipo: ");
        String tipo = teclado.nextLine();
        while(!tipo.matches("[a-zA-Z0-9_]+")){
            System.out.println("⚠️ Tipo de control no válido, inténtelo de nuevo ⚠️");
            System.out.print("Tipo: ");
            tipo = teclado.nextLine();
        }

        System.out.print("Consola compatible: ");
        String consola_compatible = teclado.nextLine();
        while(!consola_compatible.matches("[a-zA-Z]+")){
            System.out.println("⚠️ Consola no compatible, inténtelo de nuevo ⚠️");
            System.out.print("Consola compatible: ");
            consola_compatible = teclado.nextLine();
        }

        System.out.print("Estado: ");
        String estado= teclado.nextLine();
        while(!estado.matches("[a-zA-Z]+")){
            System.out.println("⚠️ Estado no válido, inténtelo de nuevo ⚠️");
            System.out.print("Estado: ");
            estado = teclado.nextLine();
        }
        Controles con= new Controles();
        con.setTipo(tipo);
        con.setConsola_compatible(consola_compatible);
        con.setEstado(estado);
        return con;
    }

    public Controles leerControlesActualizados(){
        System.out.print("Ingrese el ID del control a actualizar: ");
        int id =Integer.parseInt(teclado.nextLine());
        Controles controles=leerNuevoControl();
        controles.setId_control(id);
        return controles;
    }

    public int leerIdEliminar(){
        System.out.print("Indique el ID a eliminar: ");
        return Integer.parseInt(teclado.nextLine());
    }

    public int leerOpcion(){
        return Integer.parseInt(teclado.nextLine());
    }
}