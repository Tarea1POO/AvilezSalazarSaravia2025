package View;
import Model.Consolas;
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

    //FUNCIÓN PARA MOSTRAR POR PANTALLA LA LISTA DE CONSOLAS
    public void mostrarConsolas (List<Consolas> consolas){
        if( consolas.isEmpty()){ //SI LA LISTA ESTA VACÍA
            System.out.println("No hay consolas");

        } else{ //SI TIENE ELEMENTOS
            //RECORRE LA LISTA E IMPRIME CADA JUGADOR
            consolas.forEach(System.out::println);
        }
    }

    //FUNCIÓN PARA LEER LOS DATOS DE UNA NUEVA CONSOLA
    public Consolas leerNuevaConsola() {

        //BUCLE PARA VALIDAR QUE EL USUARIO INGRESE UN NOMBRE OBLIGATORIO
        String nombre="";
        while(nombre.trim().isEmpty()){//TRIM ELIMINA LOS ESPACIOS EN BLANCO DEL TEXTO AL INICIO Y AL FINAL
            System.out.print("Nombre: ");
            nombre=teclado.nextLine();
            if(nombre.trim().isEmpty()){
                System.out.println("⚠️ Campo requerido");
            }
        }

        //BUCLE PARA VALIDAR QUE EL USUARIO INGRESE UN FABRICANTE OBLIGATORIO
        String fabricante="";
        while(fabricante.trim().isEmpty()) {
            System.out.print("Fabricante: ");
            fabricante = teclado.nextLine();
            if (fabricante.trim().isEmpty()) {
                System.out.println("⚠️ Campo requerido");
            }
        }

        //BUCLE PARA VALIDAR QUE EL USUARIO INGRESE UN AÑO DE LANZAMIENTO VALIDO
        int anio_lanzamiento=-1;
        while(true){
            System.out.print("Año de lanzamiento: ");
            String entradaUser= teclado.nextLine().trim();

            //VALIDAR QUE NO SEA UN CAMPO VACÍO
            if(entradaUser.isEmpty()){
                System.out.println("⚠️ Campo requerido");
                continue; //PARA VOLVER A PREGUNTAR EL AÑO DE LANZAMIENTO
            }
            try{
                anio_lanzamiento=Integer.parseInt(entradaUser);
                if(anio_lanzamiento <=0){
                    System.out.println("⚠️ Solo debe ingresar números enteros positivos");
                    continue; //PARA VOLVER A PREGUNTAR EL AÑO DE LANZAMIENTO

                }
                break; //SI EL AÑO DE LANZAMIENTO ES VALIDO, SE SALE
            }catch(NumberFormatException e){//si el texto no es un numero se avisa al usuario
                System.out.println("⚠️ Solo debe ingresar dígitos");
            }
        }

        //CREAR EL OBJETO CONSOLA CON LOS DATOS OBTENIDOS
        Consolas consolas= new Consolas();
        consolas.setNombre(nombre);
        consolas.setFabricante(fabricante);
        consolas.setAnio_lanzamiento(anio_lanzamiento);
        return consolas;
    }


    //FUNCIÓN PARA LEER LOS DATOS ACTUALIZADOS DE UNA CONSOLA YA EXISTENTE
    public Consolas leerConsolaActualizadas(int id){
        Consolas consolas=leerNuevaConsola();
        //SE ASIGNA EL ID DE LA CONSOLA QUE SE ESTA MODIFICANDO
        consolas.setId_consola(id);
        return consolas;
    }

    //FUNCIÓN PARA LEER EL ID DE LA CONSOLA A ELIMINAR
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

    //FUNCIÓN PARA LEER EL ID DE LA CONSOLA QUE SE VA A ACTUALIZAR
    public int leerIdActualizar(){
        System.out.print("Ingrese el ID de la consola a actualizar:");
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