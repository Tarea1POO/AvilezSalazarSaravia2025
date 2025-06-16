package Controller;
import Model.Consolas;
import Model.ConsolasDAO;
import Model.Jugadores;
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
            //SE MUESTRA EL MENU DE JUGADORES
            view.mostrarMenu();
            //SE LEE LA OPCIÓN INGRESADA POR EL USUARIO
            opcion=view.leerOpcion();

            switch(opcion){
                case 1 -> view.mostrarConsolas(dao.obtenerTodos());

                case 2 ->{
                    dao.crearConsolas(view.leerNuevaConsola());
                    System.out.println("Consola creada y agregado a la BD correctamente");
                }
                case 3 -> {
                    //ACTUALIZA UNA CONSOLA
                    int id=view.leerIdActualizar();
                    //BUSCA LA CONSOLA QUE SE VA ACTUALIZAR
                    Consolas consolasExistente=null;
                    for(Consolas consolas: dao.obtenerTodos()){
                        if(consolas.getId_consola()==id){
                            consolasExistente=consolas;
                            break;
                        }
                    }
                    if (consolasExistente==null) {
                        System.out.println("No existe una consola con ese ID");
                    }else{
                        //LEE LOS NUEVOS DATOS PARA LA CONSOLA
                        Consolas consolas=view.leerConsolaActualizadas(id);
                        consolas.setId_consola(id);
                        boolean actualizado=dao.actualizarConsolas(consolas);
                        if(actualizado) {
                            System.out.println("Consolas actualizadas correctamente");
                        }
                    }
                }
                case 4 -> {
                    //ELIMINA UNA CONSOLA
                    int id=view.leerIdEliminar();
                    boolean eliminado=dao.eliminarConsola(id);
                    if (eliminado) {
                        System.out.println("Consola eliminada correctamente de la BD");
                    }else{
                        System.out.println("No existe una consola con ese ID");
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