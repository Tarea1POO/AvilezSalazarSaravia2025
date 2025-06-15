package View;
import Model.Jugadores;
import java.util.*;
public class JugadoresView{
    private Scanner teclado = new Scanner(System.in);

    public void mostrarMenu(){
        System.out.println("");
        System.out.println(" 👾🍕 MENÚ DE JUGADORES 👾🍕 ");
        System.out.println("1.- Listar Jugador/es 📄");
        System.out.println("2.- Crear Jugador/es 🔧");
        System.out.println("3.- Editar Jugador/es 🛠️");
        System.out.println("4.- Eliminar Jugador/es ❌");
        System.out.println("5.- Salir 🔑");
        System.out.print("Indique una opción 😁: ");
        System.out.print("");
    }
    //FUNCIÓN PARA MOSTRAR POR PANTALLA LA LISTA DE JUGADORES
    public void mostrarJugadores (List<Jugadores> jugadores) {
        if (jugadores.isEmpty()) { //SI LA LISTA ESTA VACIA
            System.out.println("");
            System.out.println("-- No hay jugadores registrados --");

        }else{ //SI TIENE ELEMENTOS, RECORRE LA LISTA E IMPRIME CADA JUGADOR
            jugadores.forEach(System.out::println);
        }
    }

    //FUNCIÓN PARA LEER LOS DATOS DE UN NUEVO JUGADOR
    public Jugadores leerNuevoJugador(){
        //BUCLE PARA VALIDAR QUE EL USUARIO INGRESE UN NOMBRE OBLIGATORIO
        String nombre = "";
        System.out.println("");
        System.out.println("👾 CREANDO NUEVO JUGADOR 👾");
        while(nombre.trim().isEmpty()){//TRIM ELIMINA LOS ESPACIOS EN BLANCO DEL TEXTO AL INICIO Y AL FINAL
            System.out.print("Nombre: ");
            nombre = teclado.nextLine();
            if(nombre.trim().isEmpty()){
                System.out.println("⚠️ No puede estar vacío, inténtelo de nuevo ⚠️");
            }else if(!nombre.matches("(?i)^[a-záéíóúñ ]{2,}$")){
                System.out.println("⚠️ Nombre inválido, inténtelo de nuevo ⚠️");
                break;
            }
        }
        //BUCLE PARA VALIDAR QUE EL USUARIO INGRESE UN APODO OBLIGATORIO
        String nickname = "";
        while(nickname.trim().isEmpty()) {
            System.out.print("Nickname: ");
            nickname = teclado.nextLine();
            if (nickname.trim().isEmpty()) {
                System.out.println("⚠️ No puede estar vacío, inténtelo de nuevo ⚠️");
            }else if(!nickname.matches("(?i)^[a-z0-9]{3,}$")){
                System.out.println("⚠️ Nickname inválido, inténtelo de nuevo ⚠️");
                break;
            }
        }
        //BUCLE PARA VALIDAR QUE EL USUARIO INGRESE UNA EDAD CORRECTA
        int edad = -1;
        while(true){
            System.out.print("Edad: ");
            String entradaUser = teclado.nextLine().trim();

            //VALIDAR QUE NO SEA UN CAMPO VACÍO
            if(entradaUser.isEmpty()){
                System.out.println("⚠️ No puede estar vacío, inténtelo de nuevo ⚠️");
                continue; //PARA VOLVER A PREGUNTAR LA EDAD
            }
            try{
                edad = Integer.parseInt(entradaUser);
                if(edad <= 0){
                    System.out.println("⚠️ Solo debe ingresar números enteros positivos, inténtelo de nuevo ⚠️");
                    continue; //PARA VOLVER A PREGUNTAR LA EDAD

                }
                break; //SI LA EDAD ES VALIDA, SE SALE
            }catch(NumberFormatException e){//SI EL TEXTO NO ES UN NÚMERO SE LE AVISA AL USUARIO
                System.out.println("⚠️ Solo debe ingresar dígitos válidos, inténtelo de nuevo ⚠️");
            }
        }

        //CREAR EL OBJETO JUGADOR CON LOS DATOS OBTENIDOS
        Jugadores ju = new Jugadores();
        ju.setNombre(nombre);
        ju.setNickname(nickname);
        ju.setEdad(edad);
        return ju;
    }

    //FUNCIÓN PARA LEER LOS DATOS ACTUALIZADOS DE UN JUGADOR YA EXISTENTE
    public Jugadores leerJugadoresActualizados(int id){
        Jugadores jugador = leerNuevoJugador();
        //SE ASIGNA EL ID DEL JUGADOR QUE SE ESTA MODIFICANDO
        jugador.setId_jugador(id);
        return jugador;
    }

    //FUNCIÓN PARA LEER EL ID DEL JUGADOR A ELIMINAR
    public int leerIdEliminar(){
        int id = -1;
        while(true){
            System.out.print("Ingrese el ID del jugador a eliminar: ");
            String entradaUser = teclado.nextLine().trim();
            if(entradaUser.isEmpty()){
                System.out.println("⚠️ No puede estar vacío, inténtelo de nuevo ⚠️");
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
               System.out.println("⚠️ Solo debe ingresar dígitos válidos, inténtelo de nuevo ⚠️");
           }
        }
        return id;
    }

    //FUNCIÓN PARA LEER EL ID DEL JUGADOR QUE SE VA A ACTUALIZAR
    public int leerIdActualizar(){
        System.out.print("Ingrese el ID del jugador a actualizar:");
        return Integer.parseInt(teclado.nextLine());
    }

    //FUNCIÓN PARA LEER LA OPCIÓN QUE EL USUARIO ESCOJA EN EL MENÚ
    public int leerOpcion(){
        int opcion = -1;
        while(true){
            String entradaUser = teclado.nextLine().trim();
            if(entradaUser.isEmpty()){
                System.out.println("");
                System.out.println("⚠️ No puede estar vacío, inténtelo de nuevo ⚠️");
                System.out.println("");
                System.out.println(" 👾🍕 MENÚ DE JUGADORES 👾🍕 ");
                System.out.println("1.- Listar Jugador/es 📄");
                System.out.println("2.- Crear Jugador/es 🔧");
                System.out.println("3.- Editar Jugador/es 🛠️");
                System.out.println("4.- Eliminar Jugador/es ❌");
                System.out.println("5.- Salir 🔑");
                System.out.print("Indique una opción 😁: ");
                continue;
            }
            try{
                opcion = Integer.parseInt(entradaUser);
                if(opcion <= 0){
                    System.out.println("");
                    System.out.println("⚠️ No puede ingresar números negativos o ceros, inténtelo de nuevo ⚠️");
                    System.out.println("");
                    System.out.println(" 👾🍕 MENÚ DE JUGADORES 👾🍕 ");
                    System.out.println("1.- Listar Jugador/es 📄");
                    System.out.println("2.- Crear Jugador/es 🔧");
                    System.out.println("3.- Editar Jugador/es 🛠️");
                    System.out.println("4.- Eliminar Jugador/es ❌");
                    System.out.println("5.- Salir 🔑");
                    System.out.print("Indique una opción 😁: ");
                    System.out.print("");
                    continue;
                }
                break;
            }catch(NumberFormatException e){
                System.out.println(" ");
                System.out.println("⚠️ Debe ingresar un número del [1-5], inténtelo de nuevo ⚠️");
                System.out.println("");
                System.out.println(" 👾🍕 MENÚ DE JUGADORES 👾🍕 ");
                System.out.println("1.- Listar Jugador/es 📄");
                System.out.println("2.- Crear Jugador/es 🔧");
                System.out.println("3.- Editar Jugador/es 🛠️");
                System.out.println("4.- Eliminar Jugador/es ❌");
                System.out.println("5.- Salir 🔑");
                System.out.print("Indique una opción 😁: ");
                System.out.print("");
            }
        }
        return opcion;
    }
}