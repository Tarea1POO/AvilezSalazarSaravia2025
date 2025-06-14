package Model;

public class Controles {
    private int id_control;
    private String tipo;
    private String consola_compatible;
    private String estado;

    //CONSTRUCTOR VACIO
    public Controles() {
    }

    //CONSTRUCTOR CON DATOS
    public Controles(int id_control, String tipo, String consola_compatible, String estado) {
        this.id_control = id_control;
        this.tipo = tipo;
        this.consola_compatible = consola_compatible;
        this.estado = estado;
    }

    //GETTER Y SETTER
    public int getId_control() {
        return id_control;
    }

    public void setId_control(int id_control) {
        this.id_control = id_control;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getConsola_compatible() {
        return consola_compatible;
    }

    public void setConsola_compatible(String consola_compatible) {
        this.consola_compatible = consola_compatible;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Control {" +
                "ID control:" + id_control +
                ", Tipo:'" + tipo + '\'' +
                ", Consola Compatible:'" + consola_compatible + '\'' +
                ", Estado:'" + estado + '\'' +
                '}';
    }
}
