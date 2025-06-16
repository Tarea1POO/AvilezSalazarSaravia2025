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

    //FUNCIÓN PARA MOSTRAR POR PANTALLA LA LISTA DE JUGADORES
    public void mostrarJugadores (List<Jugadores> jugadores){
        if( jugadores.isEmpty()){ //SI LA LISTA ESTA VACIA
            System.out.println("No hay jugadores");


        } else{//SI TIENE ELEMENTOS
            //RECORRE LA LISTA E IMPRIME CADA JUGADOR
            jugadores.forEach(System.out::println);
        }
    }

    //FUNCIÓN PARA LEER LOS DATOS DE UN NUEVO JUGADOR
    public Jugadores leerNuevoJugador() {

        //BUCLE PARA VALIDAR QUE EL USUARIO INGRESE UN NOMBRE OBLIGATORIO
        String nombre="";
        while(true){//TRIM ELIMINA LOS ESPACIOS EN BLANCO DEL TEXTO AL INICIO Y AL FINAL
            System.out.print("Nombre: ");
            nombre=teclado.nextLine();

            //VALIDAR QUE NO SEA UN CAMPO VACÍO
            if(nombre.isEmpty()){
                System.out.println("⚠️ Campo requerido");
                continue;
            }

            //VALIDAR QUE CONTENGA SOLO LETRAS Y ESPACIOS
            if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
                System.out.println("⚠️ Solo debe contener letras y espacios");
                continue;//PARA VOLVER A PREGUNTAR
            }
            break;//PARA SALIR

        }

        //BUCLE PARA VALIDAR QUE EL USUARIO INGRESE UN APODO OBLIGATORIO
        String nickname="";
        while(true){
            System.out.print("Nickname: ");
            nickname=teclado.nextLine();

            //VALIDAR QUE NO SEA UN CAMPO VACÍO
            if(nickname.isEmpty()){
                System.out.println("⚠️ Campo requerido");
                continue;//PARA VOLVER A PREGUNTAR
            }

            //VALIDAR QUE CONTENGA SOLO LETRAS Y ESPACIOS
            if (!nickname.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
                System.out.println("⚠️ Solo debe contener letras y espacios");
                continue;//PARA VOLVER A PREGUNTAR
            }
            break;//PARA SALIR

        }

        //BUCLE PARA VALIDAR QUE EL USUARIO INGRESE UNA EDAD VALIDA
        int edad=-1;
        //SE REPETIRA HASTA UNA EDAD CORRECTA
        while(true){
            System.out.print("Edad: ");
            String entradaUser= teclado.nextLine().trim();

            //VALIDAR QUE NO SEA UN CAMPO VACÍO
            if(entradaUser.isEmpty()){
                System.out.println("⚠️ Campo requerido");
                continue; //PARA VOLVER A PREGUNTAR LA EDAD
            }
            try{
                edad=Integer.parseInt(entradaUser);
                if(edad <=0){
                    System.out.println("⚠️ Solo debe ingresar números enteros positivos");
                    continue; //PARA VOLVER A PREGUNTAR LA EDAD

                }
                break; //SI LA EDAD ES VALIDA, SE SALE
            }catch(NumberFormatException e){//si el texto no es un numero se avisa al usuario
                System.out.println("⚠️ Solo debe ingresar dígitos");
            }
        }

        //CREAR EL OBJETO JUGADOR CON LOS DATOS OBTENIDOS
        Jugadores ju= new Jugadores();
        ju.setNombre(nombre);
        ju.setNickname(nickname);
        ju.setEdad(edad);
        return ju;
    }


    //FUNCIÓN PARA LEER LOS DATOS ACTUALIZADOS DE UN JUGADOR YA EXISTENTE
    public Jugadores leerJugadoresActualizados(int id){
        Jugadores ju=leerNuevoJugador();
        //SE ASIGNA EL ID DEL JUGADOR QUE SE ESTA MODIFICANDO
        ju.setId_jugador(id);
        return ju;
    }

    //FUNCIÓN PARA LEER EL ID DEL JUGADOR A ELIMINAR
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

    //FUNCIÓN PARA LEER EL ID DEL JUGADOR QUE SE VA A ACTUALIZAR
    public int leerIdActualizar(){
        System.out.print("Ingrese el ID del jugador a actualizar:");
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