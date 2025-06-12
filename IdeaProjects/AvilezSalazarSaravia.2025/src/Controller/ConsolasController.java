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
                case 2 -> dao.crearConsolas(view.leerNuevaConsola());
                case 3 -> dao.actualizarConsolas(view.leerConsolasActualizadas());
                case 4 -> dao.eliminarConsola(view.leerIdEliminar());
                case 5 -> System.out.println("Adios!!!!...");
            }
        }while(opcion !=5 );
    }
}
