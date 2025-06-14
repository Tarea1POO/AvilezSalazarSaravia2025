package View;
import Model.Jugadores;
import java.util.*;
public class JugadoresView{
    private Scanner teclado = new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println(" ");
        System.out.println(" 👾🍕 MENÚ DE JUGADORES 👾🍕 ");
        System.out.println("1.- Listar Jugadores 📄");
        System.out.println("2.- Crear Jugador 🔧");
        System.out.println("3.- Editar Jugador 🛠️");
        System.out.println("4.- Eliminar Jugador ❌");
        System.out.println("5.- Salir 🔑");
        System.out.print("Indique una opción 😁: ");
        System.out.print("");
    }

    public void mostrarJugadores (List<Jugadores> jugadores){
        if( jugadores.isEmpty()){
            System.out.println("No hay jugadores");
        } else{
            jugadores.forEach(System.out::println);
        }
    }

    public Jugadores leerNuevoJugador(){
        String nombre = "";
        System.out.println("");
        while(nombre.trim().isEmpty()){
            System.out.println("👾 CREANDO NUEVO JUGADOR 👾");
            System.out.println("Nombre: ");
            nombre = teclado.nextLine();
            if(nombre.trim().isEmpty()){
                System.out.println("⚠️ Campo requerido, inténtelo de nuevo ⚠️");
            }
        }

        String nickname = "";
        System.out.println("");
        while(nombre.trim().isEmpty()){
            System.out.println("Nickname: ");
            nickname = teclado.nextLine();
            if(nombre.trim().isEmpty()){
                System.out.println("⚠️ Campo requerido, inténtelo de nuevo ⚠️");
            }
        }

        int edad = -1;
        while(true){
            System.out.println("Edad: ");
            String entradaUser = teclado.nextLine();
            if(entradaUser.isEmpty()){
                System.out.println("⚠️ Campo requerido, inténtelo de nuevo ⚠️");
                continue;
            }
            try{
                edad = Integer.parseInt(entradaUser);
                if(edad <=0 ){
                    System.out.println("⚠️ Solo debe ingresar números enteros positivos, inténtelo de nuevo ⚠️");
                }
                break;
            }catch(NumberFormatException e){
                System.out.println("⚠️ No puede ingresar carácteres especiales, inténtelo de nuevo ⚠️");
            }
        }
        Jugadores ju = new Jugadores();
        ju.setNombre(nombre);
        ju.setNickname(nickname);
        ju.setEdad(edad);
        return ju;
    }

    public Jugadores leerJugadoresActualizados(){
        System.out.print("Ingrese el ID del jugador a actualizar: ");
        int id =Integer.parseInt(teclado.nextLine());
        Jugadores jugador = leerNuevoJugador();
        jugador.setId_jugador(id);
        return jugador;
    }

    public int leerIdEliminar(){
        int id = -1;
        while(true){
            System.out.println("Ingrese el ID a eliminar: ");
            String entradaUser = teclado.nextLine().trim();
            if(entradaUser.isEmpty()){
                System.out.println("⚠️ Campo requerido, inténtelo de nuevo ⚠️");
                continue;
            }
           try{
                id = Integer.parseInt(entradaUser);
                if(id <= 0){
                    System.out.println("⚠️ Solo debe ingresar números enteros positivos, inténtelo de nuevo ⚠️");
                    continue;
                }
                break;
           }catch(NumberFormatException e){
               System.out.println("⚠️ Solo debe ingresar dígitos, inténtelo de nuevo ⚠️");
           }
        }
        return id;
    }

    public int leerOpcion(){
        int opcion=-1;
        while(true){
            String entradaUser = teclado.nextLine().trim();
            if(entradaUser.isEmpty()){
                System.out.println("⚠️ Campo requerido, inténtelo de nuevo ⚠️");
                continue;
            }
            try{
                opcion = Integer.parseInt(entradaUser);
                break;
            }catch(NumberFormatException e){
                System.out.println("⚠️ Ingresa un número del [1-5]");
            }
        }
        return opcion;
    }
}