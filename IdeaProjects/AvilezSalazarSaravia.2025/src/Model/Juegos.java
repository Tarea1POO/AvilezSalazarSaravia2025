package Model;
public class Juegos {
    private int id_juego;
    private String titulo;
    private String genero;
    private String consola_compatible;
    private int precio;

    //CONSTRUCTOR VACÍO
    public Juegos() {
    }
    //CONSTRUCTOR CON DATOS
    public Juegos(int id_juego, String titulo, String genero, String consola_compatible, int precio) {
        this.id_juego = id_juego;
        this.titulo = titulo;
        this.genero = genero;
        this.consola_compatible = consola_compatible;
        this.precio = precio;
    }

    //GETTER Y SETTER
    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getConsola_compatible() {
        return consola_compatible;
    }

    public void setConsola_compatible(String consola_compatible) {
        this.consola_compatible = consola_compatible;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Juego |" +
                "ID Juego:" + id_juego +
                ", Titulo:'" + titulo + '\'' +
                ", Género:'" + genero + '\'' +
                ", Consola Compatible:'" + consola_compatible + '\'' +
                ", Precio:$" + precio +
                '|';
    }
}
