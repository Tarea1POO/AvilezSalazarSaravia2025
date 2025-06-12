import Controller.JugadoresController;
import Controller.JuegosController;
import Controller.ConsolasController;
import Controller.ControlesController;

public class Main{
    public static void main(String[] args) {
        new JugadoresController().iniciar();
        new JuegosController().iniciar();
        new ConsolasController().iniciar();
        new ControlesController().iniciar();
    }
}