package Controller;
import Model.Controles;
import Model.ControlesDAO;
import Model.Jugadores;
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
            //SE MUESTRA EL MENU DE JUGADORES
            view.mostrarMenu();
            //SE LEE LA OPCIÓN INGRESADA POR EL USUARIO
            opcion=view.leerOpcion();

            switch(opcion){
                case 1 -> view.mostrarControles(dao.obtenerTodos());

                case 2 ->{
                    dao.crearControles(view.leerNuevoControl());
                    System.out.println("Control creado y agregado a la BD correctamente");
                }
                case 3 -> {
                    //ACTUALIZA UN CONTROL
                    int id=view.leerIdActualizar();
                    //BUSCA EL CONTROL QUE SE VA ACTUALIZAR
                    Controles controlExistente=null;
                    for(Controles controles: dao.obtenerTodos()){
                        if(controles.getId_control()==id){
                            controlExistente=controles;
                            break;
                        }
                    }
                    if (controlExistente==null) {
                        System.out.println("No existe control con ese ID");
                    }else{
                        //LEE LOS NUEVOS DATOS PARA EL CONTROL
                        Controles controles=view.leerControlesActualizados(id);
                        controles.setId_control(id);
                        boolean actualizado=dao.actualizarControles(controles);
                        if(actualizado) {
                            System.out.println("Control actualizado correctamente");
                        }
                    }
                }
                case 4 -> {
                    //ELIMINA UN CONTROL
                    int id=view.leerIdEliminar();
                    boolean eliminado=dao.eliminarControles(id);
                    if (eliminado) {
                        System.out.println("Control eliminado correctamente de la BD");
                    }else{
                        System.out.println("No existe control con ese ID");
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