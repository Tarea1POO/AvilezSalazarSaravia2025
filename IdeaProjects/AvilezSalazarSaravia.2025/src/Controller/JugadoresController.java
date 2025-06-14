package Controller;
import Model.Jugadores;
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
            //SE MUESTRA EL MENU DE JUGADORES
            view.mostrarMenu();
            //SE LEE LA OPCIÓN INGRESADA POR EL USUARIO
            opcion=view.leerOpcion();

            switch(opcion){
                case 1 -> view.mostrarJugadores(dao.obtenerTodos());

                case 2 ->{
                    dao.crearJugador(view.leerNuevoJugador());
                    System.out.println("Jugador creado y agregado a la BD correctamente");
                }
                case 3 -> {
                    //ACTUALIZA UN JUGADOR
                    int id=view.leerIdActualizar();
                    //BUSCA EL JUGADOR QUE SE VA ACTUALIZAR
                    Jugadores jugadorExistente=null;
                    for(Jugadores ju: dao.obtenerTodos()){
                        if(ju.getId_jugador()==id){
                            jugadorExistente=ju;
                            break;
                        }
                    }
                    if (jugadorExistente==null) {
                        System.out.println("No existe jugador con ese ID");
                    }else{
                        //LEE LOS NUEVOS DATOS PARA EL JUGADOR
                        Jugadores jugador=view.leerJugadoresActualizados(id);
                        jugador.setId_jugador(id);
                        boolean actualizado=dao.actualizarJugadores(jugador);
                        if(actualizado) {
                            System.out.println("Jugador actualizado correctamente");
                        }
                    }
                }
                case 4 -> {
                    //ELIMINA UN JUGADOR
                    int id=view.leerIdEliminar();
                    boolean eliminado=dao.eliminarJugador(id);
                    if (eliminado) {
                        System.out.println("Jugador eliminado correctamente de la BD");
                    }else{
                        System.out.println("No existe jugador con ese ID");
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

