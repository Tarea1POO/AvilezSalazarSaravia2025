import Controller.ConsolasController;
import Controller.ControlesController;
import Controller.JuegosControler;
import Controller.JugadoresController;

public class Main {
    public static void main (String[] args){

        new JugadoresController().iniciar();
        new JuegosControler().iniciar();
        new ControlesController().iniciar();
        new ConsolasController().iniciar();

    }
}
