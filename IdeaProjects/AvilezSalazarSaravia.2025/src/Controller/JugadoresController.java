package Controller;
import Model.JugadoresDAO;
import View.JugadoresView;
import java.util.*;

public class JugadoresController {
    private JugadoresDAO dao;
    private JugadoresView view;

    public JugadoresController() {
        dao = new JugadoresDAO();
        view = new JugadoresView();
    }

    public void iniciar(){
        int opcion;

        do{
            view.mostrarMenu();
            opcion=view.leerOpcion();

            switch(opcion){
                case 1 -> view.mostrarJugadores(dao.obtenerTodos());
                case 2 -> dao.crearJugador(view.leerNuevoJugador());
                case 3 -> dao.actualizarJugadores(view.leerJugadoresActualizados());
                case 4 -> dao.eliminarJugador(view.leerIdEliminar());
                case 5 -> System.out.println("Adios!!!!...");
            }
        }while(opcion !=5 );
    }
}

