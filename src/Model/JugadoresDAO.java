package Model;
import java.sql.*;
import java.util.*;
public class JugadoresDAO {
    private Connection connection;

    public JugadoresDAO() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/videojuegos", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearJugador(Jugadores jugador) {
        String sql = "INSERT INTO jugadores (nombre, nickname, edad) values(?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, jugador.getNombre());
            stmt.setString(2, jugador.getNickname());
            stmt.setInt(3, jugador.getEdad());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Jugadores> obtenerTodos() {
        List<Jugadores> jugador = new ArrayList<>();
        String sql = "Select * FROM jugadores";
        try (Statement stmt = connection.createStatement()) {
            ResultSet resultado = stmt.executeQuery(sql);
            while (resultado.next()) {
                jugador.add(new Jugadores(resultado.getInt("id_jugador"),
                        resultado.getString("nombre"),
                        resultado.getString("nickname"),
                        resultado.getInt("edad")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugador;
    }
    public void actualizarJugador(Jugadores jugador){
        String sql = "UPDATE jugadores SET nombre=?, nickname=?, edad=? WHERE id_jugador=?";
        try(PreparedStatement stmt= connection.prepareStatement(sql)){
            stmt.setString(1,jugador.getNombre());
            stmt.setString(2, jugador.getNickname());
            stmt.setInt(3,jugador.getEdad());
            stmt.setInt(4,jugador.getId_jugador());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        public void eliminarJugador(int id){
            String sql = "DELETE FROM jugadores WHERE id_jugador=?";
            try(PreparedStatement stmt= connection.prepareStatement(sql)){
                stmt.setInt(1,id);
                stmt.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}