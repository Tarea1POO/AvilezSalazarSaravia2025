package View;
import Model.Controles;
import Model.Jugadores;

import java.util.*;

public class ControlesView {

    private Scanner teclado=new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println(" ");
        System.out.println(" MENÚ DE CONTROLES ");
        System.out.println("1.- Listar Controles 🗒️");
        System.out.println("2.- Crear Control 🔧");
        System.out.println("3.- Actualizar Control 🛠️ ");
        System.out.println("4.- Eliminar Control ❌ ");
        System.out.println("5.- Salir 🔑");
        System.out.print("Indique una opción: 😊 ");
    }

    //FUNCIÓN PARA MOSTRAR POR PANTALLA LA LISTA DE CONTROLES
    public void mostrarControles (List<Controles> controles){
        if( controles.isEmpty()){ //SI LA LISTA ESTA VACIA
            System.out.println("No hay controles");

        } else{ //SI TIENE ELEMENTOS
            //RECORRE LA LISTA E IMPRIME CADA JUGADOR
            controles.forEach(System.out::println);
        }
    }

    //FUNCIÓN PARA LEER LOS DATOS DE UN NUEVO CONTROL
    public Controles leerNuevoControl() {

        //BUCLE PARA VALIDAR QUE EL USUARIO INGRESE EL TIPO OBLIGATORIO
        String tipo="";
        while(tipo.trim().isEmpty()){//TRIM ELIMINA LOS ESPACIOS EN BLANCO DEL TEXTO AL INICIO Y AL FINAL
            System.out.print("Tipo: ");
            tipo=teclado.nextLine();
            if(tipo.trim().isEmpty()){
                System.out.println("⚠️ Campo requerido");
            }
        }

        //BUCLE PARA VALIDAR QUE EL USUARIO INGRESE UNA CONSOLA COMPATIBLE OBLIGATORIO
        String consola_compatible="";
        while(consola_compatible.trim().isEmpty()) {
            System.out.print("Consola compatible: ");
            consola_compatible = teclado.nextLine();
            if (consola_compatible.trim().isEmpty()) {
                System.out.println("⚠️ Campo requerido");
            }
        }

        //BUCLE PARA VALIDAR QUE EL USUARIO INGRESE EL ESTADO
        String estado="";
        while(estado.trim().isEmpty()) {
            System.out.print("Estado: ");
            estado = teclado.nextLine();
            if (estado.trim().isEmpty()) {
                System.out.println("⚠️ Campo requerido");
            }
        }

        //CREAR EL OBJETO CONTROL CON LOS DATOS OBTENIDOS
        Controles controles= new Controles();
        controles.setTipo(tipo);
        controles.setConsola_compatible(consola_compatible);
        controles.setEstado(estado);
        return controles;
    }

    //FUNCIÓN PARA LEER LOS DATOS ACTUALIZADOS DE UN CONTROL YA EXISTENTE
    public Controles leerControlesActualizados(int id){
        Controles controles=leerNuevoControl();
        //SE ASIGNA EL ID DEL CONTROL QUE SE ESTA MODIFICANDO
        controles.setId_control(id);
        return controles;
    }

    //FUNCIÓN PARA LEER EL ID DEL CONTROL A ELIMINAR
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

    //FUNCIÓN PARA LEER EL ID DEL CONTROL QUE SE VA A ACTUALIZAR
    public int leerIdActualizar(){
        System.out.print("Ingrese el ID del control a actualizar:");
        return Integer.parseInt(teclado.nextLine());
    }

    //FUNCIÓN PARA LEER LA OPCIÓN QUE EL USUARIO ESCOJA EN EL MENU
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
