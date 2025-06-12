package Model;
public class Consolas {
    private int id_consola;
    private String nombre;
    private String fabricante;
    private int anio_lanzamiento;

    public Consolas() {
    }

    public Consolas(String nombre, String fabricante, int anio_lanzamiento) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.anio_lanzamiento = anio_lanzamiento;
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

    @java.lang.Override
    public java.lang.String toString() {
        return "Consolas{" +
                "nombre='" + nombre + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", anio_lanzamiento=" + anio_lanzamiento +
                '}';
    }
}
