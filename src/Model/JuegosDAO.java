package Model;
import java.sql.*;
import java.util.*;
public class JuegosDAO {
    private Connection connection;

    public JuegosDAO(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/videojuegos", "root", "");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void crearJuegos(Juegos jue ){
        String sql = "INSERT INTO juegos(titulo, genero, consola_compatible, precio) VALUES(?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, jue.getTitulo());
            stmt.setString(2, jue.getGenero());
            stmt.setString(3, jue.getConsola_compatible());
            stmt.setInt(4, jue.getPrecio());
            stmt.executeUpdate();
            System.out.println("");
            System.out.println("-- Nuevo Juego Creado Correctamente 🎮");
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public List<Juegos> obtenerTodos(){
        List<Juegos> juegos=new ArrayList<>();
        String sql = "SELECT * FROM juegos";
        try(Statement stmt = connection.createStatement()){
            ResultSet resultado = stmt.executeQuery(sql);
            System.out.println("");
            System.out.println("-- LISTA DE JUEGOS REGISTRADOS 😜");
            while(resultado.next()){
                juegos.add(new Juegos(resultado.getInt("id_juego"),
                        resultado.getString("titulo"),
                        resultado.getString ("genero"),
                        resultado.getString("consola_compatible"),
                        resultado.getInt("precio")));

            }
        }catch(SQLException e){
            e.printStackTrace();
        }return juegos;
    }

    public void actualizarJuegos(Juegos jue ){
        String sql = "UPDATE juegos SET titulo = ?, genero = ?, consola_compatible = ?, precio = ? WHERE id_juego = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, jue.getTitulo());
            stmt.setString(2, jue.getGenero());
            stmt.setString(3, jue.getConsola_compatible());
            stmt.setInt(4, jue.getPrecio());
            stmt.setInt(5, jue.getId_juego());
            stmt.executeUpdate();
            System.out.println("");
            System.out.println("-- Juego Actualizado Correctamente 🎮");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void eliminarJuego(int id){
        String sql = "DELETE FROM juegos WHERE id_juego = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
            System.out.println("");
            System.out.println("-- Juego Eliminado Correctamente 🎮");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}