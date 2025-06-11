package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsolasDAO {
    private Connection connection;
    public ConsolasDAO() {
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/videojuegos","root", "");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void crearConsolas(Consolas consolas){
        String sql = "INSERT INTO jugador (nombre,fabricante,anio_lanzamiento) values(?,?,?)";
        try(PreparedStatement stmt= connection.prepareStatement(sql)){
            stmt.setString(1,consolas.getNombre());
            stmt.setString(2, consolas.getFabricante());
            stmt.setInt(3, consolas.getAnio_lanzamiento());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public List<Consolas> obtenerTodos() {
        List<Consolas> con = new ArrayList<>();
        String sql = "Select * FROM consolas";
        try (Statement stmt = connection.createStatement()) {
            ResultSet resultado = stmt.executeQuery(sql);
            while (resultado.next()) {
                con.add(new Consolas(resultado.getInt("id_consola"),
                        resultado.getString("nombre"),
                        resultado.getString("fabricante"),
                        resultado.getInt("anio_lanzamiento")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public void actualizarConsolas(Consolas consolas){
        String sql = "UPDATE controles SET nombre=?, fabricante=?, anio_lanzamiento=? WHERE id_consola=?";
        try(PreparedStatement stmt= connection.prepareStatement(sql)){
            stmt.setString(1,consolas.getNombre());
            stmt.setString(2, consolas.getFabricante());
            stmt.setInt(3,consolas.getAnio_lanzamiento());
            stmt.setInt(4,consolas.getId_consola());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void eliminarConsolas(int id){
        String sql = "DELETE FROM consolas WHERE id_consola=?";
        try(PreparedStatement stmt= connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
