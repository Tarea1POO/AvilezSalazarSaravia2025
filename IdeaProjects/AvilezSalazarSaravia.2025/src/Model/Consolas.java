package Model;
public class Consolas {
    private int id_consola;
    private String nombre;
    private String fabricante;
    private int anio_lanzamiento;

    //CONSTRUCTOR VACÍO
    public Consolas() {
    }

    //CONSTRUCTOR CON DATOS
    public Consolas(int id_consola, String nombre, String fabricante, int anio_lanzamiento) {
        this.id_consola = id_consola;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.anio_lanzamiento = anio_lanzamiento;
    }

    //GETTER Y SETTER

    public int getId_consola() {
        return id_consola;
    }

    public void setId_consola(int id_consola) {
        this.id_consola = id_consola;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getAnio_lanzamiento() {
        return anio_lanzamiento;
    }

    public void setAnio_lanzamiento(int anio_lanzamiento) {
        this.anio_lanzamiento = anio_lanzamiento;
    }

    @Override
    public String toString() {
        return "Consola |" +
                "ID Consola:" + id_consola +
                ", Nombre:'" + nombre + '\'' +
                ", Fabricante:'" + fabricante + '\'' +
                ", Año de lanzamiento:" + anio_lanzamiento +
                '|';
    }
}

