package View;
import Model.Juegos;
import Model.Jugadores;

import java.util.*;

public class JuegosView {

    private Scanner teclado = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println(" ");
        System.out.println(" MENÚ DE JUEGOS ");
        System.out.println("1.- Listar Juegos 🗒️");
        System.out.println("2.- Crear Juego 🔧 ");
        System.out.println("3.- Actualizar Juego 🛠️ ");
        System.out.println("4.- Eliminar Juego ❌ ");
        System.out.println("5.- Salir 🔑");
        System.out.print("Indique una opción 😊: ");
    }

    
    public void mostrarJuegos (List<Juegos> juegos){
        if( juegos.isEmpty()){
            System.out.println("No hay juegos");

        } else{ 
           
            juegos.forEach(System.out::println);
        }
    }

    
    public Juegos leerNuevoJuego() {

       
        String titulo="";
        while(titulo.trim().isEmpty()){//TRIM ELIMINA LOS ESPACIOS EN BLANCO DEL TEXTO AL INICIO Y AL FINAL
            System.out.print("Titulo: ");
            titulo=teclado.nextLine();
            if(titulo.trim().isEmpty()){
                System.out.println("⚠️ Campo requerido");
            }
        }

       
        String genero="";
        while(genero.trim().isEmpty()) {
            System.out.print("Genero: ");
            genero = teclado.nextLine();
            if (genero.trim().isEmpty()) {
                System.out.println("⚠️ Campo requerido");
            }
        }

        String consola_compatible="";
        while(consola_compatible.trim().isEmpty()) {
            System.out.print("Consola compatible: ");
            consola_compatible = teclado.nextLine();
            if (consola_compatible.trim().isEmpty()) {
                System.out.println("⚠️ Campo requerido");
            }
        }

      
        int precio=-1;
        while(true){
            System.out.print("Precio: ");
            String entradaUser= teclado.nextLine().trim();

           
            if(entradaUser.isEmpty()){
                System.out.println("⚠️ Campo requerido");
                continue; //PARA VOLVER A PREGUNTAR EL PRECIO
            }
            try{
                precio=Integer.parseInt(entradaUser);
                if(precio <=0){
                    System.out.println("⚠️ Solo debe ingresar números enteros positivos");
                    continue; //PARA VOLVER A PREGUNTAR EL PRECIO
                }
                break; 
            }catch(NumberFormatException e){//si el texto no es un numero se avisa al usuario
                System.out.println("⚠️ Solo debe ingresar dígitos");
            }
        }

        
        Juegos juegos= new Juegos();
        juegos.setTitulo(titulo);
        juegos.setGenero(genero);
        juegos.setConsola_compatible(consola_compatible);
        juegos.setPrecio(precio);
        return juegos;
    }

   
    public Juegos leerJuegosActualizados(int id){
        Juegos jue=leerNuevoJuego();
       
        jue.setId_juego(id);
        return jue;
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

    //FUNCIÓN PARA LEER EL ID DEL JUEGO QUE SE VA A ACTUALIZAR
    public int leerIdActualizar(){
        System.out.print("Ingrese el ID del juego a actualizar:");
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
