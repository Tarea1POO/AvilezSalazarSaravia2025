package Model;

public class Controles {
    private int id_control;
    private String tipo;
    private String consola_compatible;
    private String estado;

    public Controles() {
    }

    public Controles(int id_control, String tipo, String consola_compatible, String estado) {
        this.id_control = id_control;
        this.tipo = tipo;
        this.consola_compatible = consola_compatible;
        this.estado = estado;
    }

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
        return "Controles{" +
                "id_control=" + id_control +
                ", tipo='" + tipo + '\'' +
                ", consola_compatible='" + consola_compatible + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
