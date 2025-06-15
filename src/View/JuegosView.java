package View;
import Model.Juegos;
import java.util.*;
public class JuegosView {
    private Scanner teclado = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println(" ");
        System.out.println(" 🕹️♦️ MENÚ DE JUEGOS ♦️🕹️ ");
        System.out.println("1.- Listar Juego/s 🗒️");
        System.out.println("2.- Crear Juego/s 🔧");
        System.out.println("3.- Editar Juego/s 🛠️");
        System.out.println("4.- Eliminar Juego/s ❌");
        System.out.println("5.- Salir 🔑");
        System.out.print("Indique una opción 😁: ");
        System.out.print("");
    }

    public void mostrarJuegos(List<Juegos> juegos) {
        if (juegos.isEmpty()) {
            System.out.println("");
            System.out.println("-- No hay juegos registrados --");
        } else {
            juegos.forEach(System.out::println);
        }
    }

    public Juegos leerNuevoJuego() {
        System.out.println(" ");
        System.out.println("🎯 CREANDO UN NUEVO JUEGO 🎯");

        System.out.print("Titulo: ");
        String titulo = teclado.nextLine().trim();

        //(?i): IGNORA MAYÚSCULAS/MINÚSCULAS
        // ^(?=.*[a-záéíóúñ]): ASEGURA QUE LA CADENA COMPLETA SE CUMPLA
        // [a-záéíóúñ ]{2,}$: SOLO ACEPTA LETRAS, TILDES Y ESPACIOS, MÍNIMO 2 CARACTERES

        while (!titulo.matches(("(?i)^(?=.*[a-záéíóúñ])[a-záéíóúñ ]{2,}$"))){
            System.out.println("⚠️ Título no válido, inténtelo de nuevo ⚠️");
            System.out.print("Título: ");
            titulo = teclado.nextLine().trim();
        }

        System.out.print("Género: ");
        String genero = teclado.nextLine();
        while (!genero.trim().matches(("[a-zA-ZáéíóúÁÉÍÓÚñÑ]{2,}+"))){
            System.out.println("⚠️ Género no válido, inténtelo de nuevo ⚠️");
            System.out.print("Género: ");
            genero = teclado.nextLine();
        }

        System.out.print("Consola compatible: ");
        String consola_compatible = teclado.nextLine();
        //(?i): IGNORA MAYÚSCULAS/MINÚSCULAS
        // [a-záéíóúñ0-9]: PERMITE LETRAS, TILDES, NÚMEROS Y ESPACIOS
        // {2,}$: SOLO ACEPTA MÍNIMO 2 CARACTERES

        while (!consola_compatible.trim().matches(("(?i)^[a-záéíóúñ0-9]{2,}$"))){
            System.out.println("⚠️ Consola no compatible, inténtelo de nuevo ⚠️");
            System.out.print("Consola compatible: ");
            consola_compatible = teclado.nextLine();
        }

        int precio = 0;
        System.out.print("Precio: ");
        String precioS = teclado.nextLine();
        while (!precioS.matches("\\d{1,6}")){
            System.out.println("⚠️ Precio no válido, inténtelo de nuevo ⚠️");
            System.out.print("Precio: ");
            precioS = teclado.nextLine();
        }
        precio = Integer.parseInt(precioS);
        Juegos juego = new Juegos();
        juego.setTitulo(titulo);
        juego.setGenero(genero);
        juego.setConsola_compatible(consola_compatible);
        juego.setPrecio(precio);
        return juego;
    }

    public Juegos leerJuegosActualizados(){
        System.out.println(" ");
        System.out.print("Ingrese el ID del juego a actualizar: ");
        int id = Integer.parseInt(teclado.nextLine());
        Juegos juegos = leerNuevoJuego();
        juegos.setId_juego(id);
        return juegos;
    }

    public int leerIdEliminar(List<Juegos> juegos){
        int id = -1;
        while(true){
            System.out.println("");
            System.out.println("Ingrese el ID del juego a eliminar: ");
            String respuesta = teclado.nextLine().trim();

            if(respuesta.isEmpty()){
                System.out.println("");
                System.out.println("⚠️ No puede estar vació, inténtelo de nuevo ⚠️");
                continue;
            }

            try{
                id = Integer.parseInt(respuesta);
                if(id <= 0){
                    System.out.println("⚠️ No puede ingresar números negativos, inténtelo de nuevo ⚠️");
                    continue;
                }

                //VERIFICAR SI EL ID EXISTE EN LA LISTA DE JUEGOS REGISTRADOS
                boolean existeID = false;

                for(Juegos juego : juegos){
                    if(juego.getId_juego() == id){
                        System.out.println("El ID si aparece registrado en la lista de juegos");
                        existeID = true;
                        break;
                    }
                }
                if(!existeID){
                    System.out.println("⚠️ No existe un juego con ese ID, inténtelo de nuevo ⚠️");
                    continue;
                }
                break;
            }catch(NumberFormatException e){
                System.out.println("⚠️ No puede ingresar números negativos, inténtelo de nuevo ⚠️");
            }
        }
        return id;
    }

    public int leerOpcion(){
        return leerEnteroValido();
    }

    // MÉTODO DE UTILIDAD PARA LEER ENTEROS VÁLIDOS SIN EXCEPCIÓN
    private int leerEnteroValido(){
        int numero = -1;
        boolean valido = false;
        while (!valido){
            try {
                String entrada = teclado.nextLine();
                numero = Integer.parseInt(entrada);
                if (numero <= 0){
                    System.out.println("");
                    System.out.println("⚠️ No puede ingresar números negativos o cero como opción, ingrese un número positivo ⚠️");
                    System.out.println(" ");
                    System.out.println(" 🕹️♦️ MENÚ DE JUEGOS ♦️🕹️ ");
                    System.out.println("1.- Listar Juego/s 🗒️");
                    System.out.println("2.- Crear Juego/s 🔧");
                    System.out.println("3.- Editar Juego/s 🛠️");
                    System.out.println("4.- Eliminar Juego/s ❌");
                    System.out.println("5.- Salir 🔑");
                    System.out.print("Indique una opción 😁: ");
                    System.out.print("");
                }else{
                    valido = true;
                }
            } catch (NumberFormatException e){
                System.out.println(" ");
                System.out.println("⚠️ Entrada no válida, ingrese un número entero positivo ⚠️");
                System.out.println(" ");
                System.out.println(" 🕹️♦️ MENÚ DE JUEGOS ♦️🕹️ ");
                System.out.println("1.- Listar Juego/s 🗒️");
                System.out.println("2.- Crear Juego/s 🔧");
                System.out.println("3.- Editar Juego/s 🛠️");
                System.out.println("4.- Eliminar Juego/s ❌");
                System.out.println("5.- Salir 🔑");
                System.out.print("Indique una opción 😁: ");
                System.out.print("");
            }
        }
        return numero;
    }
}