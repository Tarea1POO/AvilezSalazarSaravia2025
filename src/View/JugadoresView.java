package View;
import Model.Jugadores;
import java.util.*;

public class JugadoresView {

    private Scanner teclado=new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println(" ");
        System.out.println(" MENÚ DE JUGADORES ");
        System.out.println("1.- Listar Jugadores 🗒️ ");
        System.out.println("2.- Crear Jugador 🔧 ");
        System.out.println("3.- Actulizar Jugador 🛠️ ");
        System.out.println("4.- Eliminar Jugador ❌");
        System.out.println("5.- Salir 🔑");
        System.out.print("Ingrese una opción 😊: ");
    }

    
    public void mostrarJugadores (List<Jugadores> jugadores){
        if( jugadores.isEmpty()){ //SI LA LISTA ESTA VACIA
            System.out.println("No hay jugadores");


        } else{
            jugadores.forEach(System.out::println);
        }
    }

  
    public Jugadores leerNuevoJugador() {

       
        String nombre="";
        while(true){
            System.out.print("Nombre: ");
            nombre=teclado.nextLine();

           
            if(nombre.isEmpty()){
                System.out.println("⚠️ Campo requerido");
                continue;
            }

          
            if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
                System.out.println("⚠️ Solo debe contener letras y espacios");
                continue;
            }
            break;

        }

       
        String nickname="";
        while(true){
            System.out.print("Nickname: ");
            nickname=teclado.nextLine();

          
            if(nickname.isEmpty()){
                System.out.println("⚠️ Campo requerido");
                continue;
            }

           
            if (!nickname.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
                System.out.println("⚠️ Solo debe contener letras y espacios");
                continue;
            }
            break;

        }

        
        int edad=-1;
       
        while(true){
            System.out.print("Edad: ");
            String entradaUser= teclado.nextLine().trim();

         
            if(entradaUser.isEmpty()){
                System.out.println("⚠️ Campo requerido");
                continue;
            }
            try{
                edad=Integer.parseInt(entradaUser);
                if(edad <=0){
                    System.out.println("⚠️ Solo debe ingresar números enteros positivos");
                    continue; 

                }
                break; 
            }catch(NumberFormatException e){
                System.out.println("⚠️ Solo debe ingresar dígitos");
            }
        }

        
        Jugadores ju= new Jugadores();
        ju.setNombre(nombre);
        ju.setNickname(nickname);
        ju.setEdad(edad);
        return ju;
    }


   
    public Jugadores leerJugadoresActualizados(int id){
        Jugadores ju=leerNuevoJugador();
      
        ju.setId_jugador(id);
        return ju;
    }

  
    public int leerIdEliminar() {
        int id = -1;
        while (true) {
            System.out.print("Ingrese el ID a eliminar: ");
            String entradaUser = teclado.nextLine().trim();
            if(entradaUser.isEmpty()){
                System.out.println("⚠️ Campo requerido");
                continue;
            }
            try {
                id = Integer.parseInt(entradaUser);
                if (id <= 0) {
                    System.out.println("⚠️ Solo debe ingresar números enteros positivos");
                    continue;
                }
                break;
            }catch(NumberFormatException e){
                System.out.println("⚠️ Solo debe ingresar dígitos");
            }
        }
        return id;
    }

   
    public int leerIdActualizar(){
        System.out.print("Ingrese el ID del jugador a actualizar:");
        return Integer.parseInt(teclado.nextLine());
    }

   
    public int leerOpcion(){
        int opcion=-1;
        while(true){
            String entradaUser=teclado.nextLine().trim();
            if(entradaUser.isEmpty()){
                System.out.println("⚠️ Campo requerido");
                continue;
            }
            try{
                opcion=Integer.parseInt(entradaUser);
                break;
            }catch(NumberFormatException e){
                System.out.println("⚠️ Ingresar un numero del [1-5]");
            }
        }
        return opcion;
    }
}
