package Controller;
import Model.ConsolasDAO;
import View.ConsolasView;
import java.util.*;

public class ConsolasController {
    private ConsolasDAO dao;
    private ConsolasView view;

    public ConsolasController() {
        dao = new ConsolasDAO();
        view = new ConsolasView();
    }

    public void iniciar(){
        int opcion;

        do{
            view.mostrarMenu();
            opcion=view.leerOpcion();

            switch(opcion){
                case 1 -> view.mostrarConsolas(dao.obtenerTodos());
                case 2 -> {
                    dao.crearConsolas(view.leerNuevaConsola());
                    System.out.println("Consola creado y agregado a la BD correctamente");
                }
                case 3 -> {
                    dao.actualizarConsolas(view.leerConsolasActualizadas());
                    System.out.println("Consola actualizado correctamente en la BD");
                }
                case 4 -> dao.eliminarConsola(view.leerIdEliminar());
                case 5 -> System.out.println("Volviendo al menu principal...👌");
                default -> {
                    System.out.println("Opción invalida, Ingrese una opción del [1-5]");
                }
            }
        }while(opcion !=5 );
    }
}
