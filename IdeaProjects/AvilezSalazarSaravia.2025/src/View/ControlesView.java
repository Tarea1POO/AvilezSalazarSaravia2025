package View;
import Model.Controles;
import java.util.*;

public class ControlesView {

    private Scanner teclado=new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println(" MENÚ DE CONTROLES ");
        System.out.println("1.- Listar Controles 🗒️");
        System.out.println("2.- Crear Control 🔧");
        System.out.println("3.- Actualizar Control 🛠️ ");
        System.out.println("4.- Eliminar Control ❌ ");
        System.out.println("5.- Salir 🔑");
        System.out.print("Indique una opción: 😊 ");

    }

    public void mostrarControles (List<Controles> controles){
        if( controles.isEmpty()){
            System.out.println("No hay controles");


        } else{
            controles.forEach(System.out::println);
        }
    }

    public Controles leerNuevoControl() {
        System.out.print("Tipo: ");
        String tipo = teclado.nextLine();
        System.out.print("Consola compatible: ");
        String consola_compatible = teclado.nextLine();
        System.out.print("Estado:");
        String estado= teclado.nextLine();
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
