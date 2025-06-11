package Controller;
import Model.Controles;
import Model.ControlesDAO;
import View.ControlesView;

public class ControlesController {
    private ControlesDAO dao;
    private ControlesView view;

    public ControlesController(){
        dao=new ControlesDAO();
        view=new ControlesView();
    }
    public void iniciar(){
        int op;
        do{
            view.mostrarMenu();
            op=view.leerOpcion();

            switch (op){
                case 1 -> view.mostrarControles(dao.obtenerTodos());
                case 2 -> dao.crearControles(view.leerNuevoControles());
                case 3 -> dao.actualizarControles(view.leerControlesACtualizar());
                case 4 -> dao.eliminarControles(view.leerIdEliminar());
                case 5 -> System.out.println("Sayonara!!!🙈🙉🙈🙉");
            }
        }while(op!=5);
    }
}
