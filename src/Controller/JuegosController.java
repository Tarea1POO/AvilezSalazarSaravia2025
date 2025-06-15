package Controller;
import Model.Juegos;
import Model.JuegosDAO;
import View.JuegosView;
import java.util.*;
public class JuegosController {
    private JuegosDAO dao;
    private JuegosView view;

    public JuegosController() {
        dao = new JuegosDAO();
        view = new JuegosView();
    }

    public void iniciar(){
        int opcion;

        do{
            view.mostrarMenu();
            opcion = view.leerOpcion();

            switch(opcion){
                case 1 -> view.mostrarJuegos(dao.obtenerTodos());
                case 2 -> dao.crearJuegos(view.leerNuevoJuego());
                case 3 -> dao.actualizarJuegos(view.leerJuegosActualizados());
                case 4 -> {List<Juegos> listaDeJuegos = dao.obtenerTodos();
                    int idAEliminar = view.leerIdEliminar(listaDeJuegos); dao.eliminarJuego(idAEliminar);
                }
                case 5 -> { System.out.println(""); System.out.println("Adios!!!!...😜"); }
            }
        }while(opcion !=5 );
    }
}
