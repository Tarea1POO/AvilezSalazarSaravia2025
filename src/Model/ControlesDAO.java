package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControlesDAO {
    private Connection connection;
    public ControlesDAO() {
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/videojuegos","root", "");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void crearControles(Controles controles){
        String sql = "INSERT INTO jugador (tipo,consola_compatible,estado) values(?,?,?)";
        try(PreparedStatement stmt= connection.prepareStatement(sql)){
            stmt.setString(1,controles.getTipo());
            stmt.setString(2, controles.getConsola_compatible());
            stmt.setString(3, controles.getEstado());

            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public List<Controles> obtenerTodos() {
        List<Controles> con = new ArrayList<>();
        String sql = "Select * FROM controles";
        try (Statement stmt = connection.createStatement()) {
            ResultSet resultado = stmt.executeQuery(sql);
            while (resultado.next()) {
                con.add(new Controles(resultado.getInt("id_control"),
                        resultado.getString("tipo"),
                        resultado.getString("consola_compatible"),
                        resultado.getString("estado")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public void actualizarControles(Controles controles){
        String sql = "UPDATE controles SET tipo=?, consola_compatible=?, estado=? WHERE id_control=?";
        try(PreparedStatement stmt= connection.prepareStatement(sql)){
            stmt.setString(1,controles.getTipo());
            stmt.setString(2, controles.getConsola_compatible());
            stmt.setString(3,controles.getEstado());
            stmt.setInt(4,controles.getId_control());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void eliminarControles(int id){
        String sql = "DELETE FROM controles WHERE id_controles=?";
        try(PreparedStatement stmt= connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
