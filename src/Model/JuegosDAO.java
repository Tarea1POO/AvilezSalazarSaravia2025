package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JuegosDAO {
    private Connection connection;

    public JuegosDAO() {
        try{
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/videojuegos","root", "");
        }catch (SQLException e){
                e.printStackTrace();
        }
    }
    public void crearJuegos(Juegos jg){
        String sql = "INSERT INTO juegos (titulo,genero,consola_compatible,precio) values(?,?,?,?)";
        try(PreparedStatement stmt= connection.prepareStatement(sql)){
            stmt.setString(1,jg.getTitulo());
            stmt.setString(2, jg.getGenero());
            stmt.setString(3,jg.getConsola_compatible());
            stmt.setInt(4, jg.getPrecio());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public List<Juegos> obtenerTodos(){
        List<Juegos> j = new ArrayList<>();
        String sql = "Select * FROM jugos";
        try(Statement stmt = connection.createStatement()){
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                j.add(new Juegos( resultado.getInt("id_juego"),
                        resultado.getString("titulo"),
                        resultado.getString("genero"),
                        resultado.getString("consola_compatible"),
                        resultado.getInt("precio")
                        ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }return j;
    }
    public void actualizarJuegos(Juegos jg){
        String sql = "UPDATE juegos SET titulo=?, genero=?, consola_compatible=? WHERE id_juego=?";
        try(PreparedStatement stmt= connection.prepareStatement(sql)){
            stmt.setString(1,jg.getTitulo());
            stmt.setString(2, jg.getGenero());
            stmt.setString(3,jg.getConsola_compatible());
            stmt.setInt(4,jg.getPrecio());
            stmt.setInt(5,jg.getId_juego());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void eliminarJuego(int id){
        String sql = "DELETE FROM juegos WHERE id_juegos=?";
        try(PreparedStatement stmt= connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
