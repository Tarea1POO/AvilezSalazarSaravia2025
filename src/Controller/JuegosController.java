package Controller;
import Model.Juegos;
import Model.JuegosDAO;
import Model.Jugadores;
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
            //SE MUESTRA EL MENU DE JUEGOS
            view.mostrarMenu();
            //SE LEE LA OPCIÓN INGRESADA POR EL USUARIO
            opcion=view.leerOpcion();

            switch(opcion){
                case 1 -> view.mostrarJuegos(dao.obtenerTodos());

                case 2 ->{
                    dao.crearJuegos(view.leerNuevoJuego());
                    System.out.println("Juego creado y agregado a la BD correctamente");
                }
                case 3 -> {
                    //ACTUALIZA UN JUEGO
                    int id=view.leerIdActualizar();
                    //BUSCA EL JUEGO QUE SE VA ACTUALIZAR
                    Juegos juegoExistente=null;
                    for(Juegos jue: dao.obtenerTodos()){
                        if(jue.getId_juego()==id){
                            juegoExistente=jue;
                            break;
                        }
                    }
                    if (juegoExistente==null) {
                        System.out.println("No existe juego con ese ID");
                    }else{
                        //LEE LOS NUEVOS DATOS PARA EL JUGADOR
                        Juegos juegos=view.leerJuegosActualizados(id);
                        juegos.setId_juego(id);
                        boolean actualizado=dao.actualizarJuegos(juegos);
                        if(actualizado) {
                            System.out.println("Juego actualizado correctamente");
                        }
                    }
                }
                case 4 -> {
                    //ELIMINA UN JUGADOR
                    int id=view.leerIdEliminar();
                    boolean eliminado=dao.eliminarJuego(id);
                    if (eliminado) {
                        System.out.println("Juego eliminado correctamente de la BD");
                    }else{
                        System.out.println("No existe juego con ese ID");
                    }
                }
                case 5 -> System.out.println("Volviendo al menu principal...👌");
                default -> {
                    System.out.println("Opción invalida, ingrese una opción del [1-5]");
                }
            }
        }while(opcion !=5 );
    }
}