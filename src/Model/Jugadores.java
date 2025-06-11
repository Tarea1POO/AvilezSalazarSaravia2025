package Model;

public class Jugadores {
    private int id_jugador;
    private String nombre;
    private String nickname;
    private int edad;

    public Jugadores() {
    }

    public Jugadores(int id_jugador, String nombre, String nickname, int edad) {
        this.id_jugador = id_jugador;
        this.nombre = nombre;
        this.nickname = nickname;
        this.edad = edad;
    }

    public int getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(int id_jugador) {
        this.id_jugador = id_jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Jugadores{" +
                "id_jugador=" + id_jugador +
                ", nombre='" + nombre + '\'' +
                ", nickname='" + nickname + '\'' +
                ", edad=" + edad +
                '}';
    }
}
