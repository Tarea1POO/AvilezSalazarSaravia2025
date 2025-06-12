package Controller;
import Model.ControlesDAO;
import View.ControlesView;
import java.util.*;

public class ControlesController {
    private ControlesDAO dao;
    private ControlesView view;

    public ControlesController() {
        dao = new ControlesDAO();
        view = new ControlesView();
    }

    public void iniciar(){
        int opcion;

        do{
            view.mostrarMenu();
            opcion=view.leerOpcion();

            switch(opcion){
                case 1 -> view.mostrarControles(dao.obtenerTodos());
                case 2 -> dao.crearControles(view.leerNuevoControl());
                case 3 -> dao.actualizarControles(view.leerControlesActualizados());
                case 4 -> dao.eliminarControles(view.leerIdEliminar());
                case 5 -> System.out.println("Volviendo al menu principal...👌");
            }
        }while(opcion !=5 );
    }
}

