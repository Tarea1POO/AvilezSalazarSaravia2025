package Controller;
import Model.Consolas;
import Model.ConsolasDAO;
import View.ConsolasView;

public class ConsolasController {
    private ConsolasDAO dao;
    private ConsolasView view;

    public ConsolasController(){
        dao=new ConsolasDAO();
        view=new ConsolasView();
    }
    public void iniciar(){
        int op;
        do{
            view.mostrarMenu();
            op=view.leerOpcion();

            switch (op){
                case 1 -> view.mostrarConsolas(dao.obtenerTodos());
                case 2 -> dao.crearConsolas(view.leerNuevoConsolas());
                case 3 -> dao.actualizarConsolas(view.leerConsolasACtualizar());
                case 4 -> dao.eliminarConsolas(view.leerIdEliminar());
                case 5 -> System.out.println("Sayonara!!!🙈🙉🙈🙉");
            }
        }while(op!=5);
    }
}
