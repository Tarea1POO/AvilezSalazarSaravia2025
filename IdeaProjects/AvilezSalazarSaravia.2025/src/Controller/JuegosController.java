package Controller;
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
            opcion=view.leerOpcion();

            switch(opcion){
                case 1 -> view.mostrarJuegos(dao.obtenerTodos());
                case 2 -> {
                    dao.crearJuegos(view.leerNuevoJuego());
                    System.out.println("Juego creado y agregado a la BD correctamente");
                }
                case 3 -> {
                    dao.actualizarJuegos(view.leerJuegosActualizados());
                    System.out.println("Juego actualizado correctamente en la BD");
                }
                case 4 -> dao.eliminarJuego(view.leerIdEliminar());
                case 5 -> System.out.println("Volviendo al menu principal...👌");
                default -> {
                    System.out.println("Opción invalida, Ingrese una opción del [1-5]");
                }
            }
        }while(opcion !=5 );
    }
}


