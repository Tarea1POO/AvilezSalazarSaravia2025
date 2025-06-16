package View;
import Model.Juegos;
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

    //FUNCIÓN PARA MOSTRAR POR PANTALLA LA LISTA DE JUEGOS
    public void mostrarJuegos (List<Juegos> juegos){
        if( juegos.isEmpty()){ //SI LA LISTA ESTA VACIA
            System.out.println("No hay juegos");

        } else{ //SI TIENE ELEMENTOS
            //RECORRE LA LISTA E IMPRIME CADA JUEGO
            juegos.forEach(System.out::println);
        }
    }

    //FUNCIÓN PARA LEER LOS DATOS DE UN NUEVO JUEGO
    public Juegos leerNuevoJuego() {

        //BUCLE PARA VALIDAR QUE EL USUARIO INGRESE UN TITULO OBLIGATORIO
        String titulo="";
        while(true){
            System.out.print("Titulo: ");
            titulo=teclado.nextLine();

            //VALIDAR QUE NO SEA UN CAMPO VACÍO
            if(titulo.trim().isEmpty()){
                System.out.println("⚠️ Campo requerido");
                continue;//PARA VOLVER A PREGUNTAR
            }

            //VALIDAR QUE CONTENGA SOLO LETRAS Y ESPACIOS
            if (!titulo.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
                System.out.println("⚠️ Solo debe contener letras y espacios");
                continue;//PARA VOLVER A PREGUNTAR
            }
            break;//PARA SALIR

        }
        //BUCLE PARA VALIDAR QUE EL USUARIO INGRESE UN GENERO OBLIGATORIO
        String genero="";
        while(true){
            System.out.print("Genero: ");
            genero=teclado.nextLine();

            //VALIDAR QUE NO SEA UN CAMPO VACÍO
            if(genero.trim().isEmpty()){
                System.out.println("⚠️ Campo requerido");
                continue;//PARA VOLVER A PREGUNTAR
            }

            //VALIDAR QUE CONTENGA SOLO LETRAS Y ESPACIOS
            if (!genero.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
                System.out.println("⚠️ Solo debe contener letras y espacios");
                continue;//PARA VOLVER A PREGUNTAR
            }
            break;//PARA SALIR

        }


        System.out.print("Consola Compatible: ");
        String consola_compatible = teclado.nextLine();

        while(!consola_compatible.matches("[a-zA-Z0-9]+")){
            System.out.println("⚠️ Consola no valida");
            System.out.print("Consola Compatible: ");
            consola_compatible = teclado.nextLine();
        }

        //BUCLE PARA VALIDAR QUE EL USUARIO INGRESE UN PRECIO VALIDO
        int precio=-1;
        while(true){
            System.out.print("Precio: ");
            String entradaUser= teclado.nextLine().trim();

            //VALIDAR QUE NO SEA UN CAMPO VACÍO
            if(entradaUser.trim().isEmpty()){
                System.out.println("⚠️ Campo requerido");
                continue; //PARA VOLVER A PREGUNTAR EL PRECIO
            }
            try{
                precio=Integer.parseInt(entradaUser);
                if(precio <0){
                    System.out.println("⚠️ Solo debe ingresar números enteros positivos");
                    continue; //PARA VOLVER A PREGUNTAR EL PRECIO
                }
                break; //SI EL PRECIO ES VALIDO, SE SALE
            }catch(NumberFormatException e){//si el texto no es un numero se avisa al usuario
                System.out.println("⚠️ Solo debe ingresar dígitos");
            }
        }

        //CREA EL OBJETO JUEGO CON LOS DATOS OBTENIDOS
        Juegos juegos= new Juegos();
        juegos.setTitulo(titulo);
        juegos.setGenero(genero);
        juegos.setConsola_compatible(consola_compatible);
        juegos.setPrecio(precio);
        return juegos;
    }

    //FUNCIÓN PARA LEER LOS DATOS ACTUALIZADOS DE UN JUEGO YA EXISTENTE
    public Juegos leerJuegosActualizados(int id){
        Juegos jue=leerNuevoJuego();
        //SE ASIGNA EL ID DEL JUEGO QUE SE ESTA MODIFICANDO
        jue.setId_juego(id);
        return jue;
    }

    //FUNCIÓN PARA LEER EL ID DEL JUEGO A ELIMINAR
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