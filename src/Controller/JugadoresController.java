package Controller;
import Model.Jugadores;
import Model.JugadoresDAO;
import View.JugadoresView;
public class JugadoresController {
    private JugadoresDAO dao;
    private JugadoresView view;

    public JugadoresController(){
        dao=new JugadoresDAO();
        view=new JugadoresView();
    }
    public void iniciar(){
        int op;
        do{
            view.mostrarMenu();
            op=view.leerOpcion();

            switch (op){
                case 1 -> view.mostrarJugadores(dao.obtenerTodos());
                case 2 -> dao.crearJugador(view.leerNuevoJugador());
                case 3 -> dao.actualizarJugador(view.leerJugadorACtualizar());
                case 4 -> dao.eliminarJugador(view.leerIdEliminar());
                case 5 -> System.out.println("Sayonara!!!🙈🙉🙈🙉");
            }
        }while(op!=5);
    }
}
