package Controller;
import Model.Juegos;
import Model.JuegosDAO;
import View.JuegosView;

public class JuegosControler {
    private JuegosDAO dao;
    private JuegosView view;

    public JuegosControler(){
        dao=new JuegosDAO();
        view=new JuegosView();
    }
    public void iniciar(){
        int op;
        do{
            view.mostrarMenu();
            op=view.leerOpcion();

            switch (op){
                case 1 -> view.mostrarJuegos(dao.obtenerTodos());
                case 2 -> dao.crearJuegos(view.leerNuevoJuegos());
                case 3 -> dao.actualizarJuegos(view.leerJuegosACtualizar());
                case 4 -> dao.eliminarJuego(view.leerIdEliminar());
                case 5 -> System.out.println("Sayonara!!!🙈🙉🙈🙉");
            }
        }while(op!=5);
    }



}
