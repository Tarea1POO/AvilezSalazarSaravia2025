package View;
import Model.Consolas;
import Model.Jugadores;

import java.util.*;

public class ConsolasView {

    private Scanner teclado=new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println(" ");
        System.out.println(" MENÚ DE CONSOLAS ");
        System.out.println("1.- Listar Consolas 🗒️ ");
        System.out.println("2.- Crear Consola 🔧");
        System.out.println("3.- Actualizar Consola 🛠️");
        System.out.println("4.- Eliminar Consola ❌ ");
        System.out.println("5.- Salir 🔑 ");
        System.out.print("Indique una opción 😊: ");
    }

    
    public void mostrarConsolas (List<Consolas> consolas){
        if( consolas.isEmpty()){ //SI LA LISTA ESTA VACÍA
            System.out.println("No hay consolas");

        } else{ 
           
            consolas.forEach(System.out::println);
        }
    }

    
    public Consolas leerNuevaConsola() {

        
        String nombre="";
        while(nombre.trim().isEmpty()){
            System.out.print("Nombre: ");
            nombre=teclado.nextLine();
            if(nombre.trim().isEmpty()){
                System.out.println("⚠️ Campo requerido");
            }
        }

       
        String fabricante="";
        while(fabricante.trim().isEmpty()) {
            System.out.print("Fabricante: ");
            fabricante = teclado.nextLine();
            if (fabricante.trim().isEmpty()) {
                System.out.println("⚠️ Campo requerido");
            }
        }

       
        int anio_lanzamiento=-1;
        while(true){
            System.out.print("Año de lanzamiento: ");
            String entradaUser= teclado.nextLine().trim();

            //VALIDAR QUE NO SEA UN CAMPO VACÍO
            if(entradaUser.isEmpty()){
                System.out.println("⚠️ Campo requerido");
                continue; 
            }
            try{
                anio_lanzamiento=Integer.parseInt(entradaUser);
                if(anio_lanzamiento <=0){
                    System.out.println("⚠️ Solo debe ingresar números enteros positivos");
                    continue; 

                }
                break; 
            }catch(NumberFormatException e){
                System.out.println("⚠️ Solo debe ingresar dígitos");
            }
        }

       
        Consolas consolas= new Consolas();
        consolas.setNombre(nombre);
        consolas.setFabricante(fabricante);
        consolas.setAnio_lanzamiento(anio_lanzamiento);
        return consolas;
    }


   
    public Consolas leerConsolaActualizadas(int id){
        Consolas consolas=leerNuevaConsola();
        //SE ASIGNA EL ID DE LA CONSOLA QUE SE ESTA MODIFICANDO
        consolas.setId_consola(id);
        return consolas;
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
        System.out.print("Ingrese el ID de la consola a actualizar:");
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
