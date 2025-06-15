package Model;
import java.sql.*;
import java.util.*;
public class ConsolasDAO{
    private Connection connection;

    public ConsolasDAO(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/videojuegos", "root", "");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void crearConsolas(Consolas co ){
        String sql = "INSERT INTO consolas(nombre, fabricante, anio_lanzamiento) VALUES(?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, co.getNombre());
            stmt.setString(2, co.getFabricante());
            stmt.setInt(3, co.getAnio_lanzamiento());
            stmt.executeUpdate();
            System.out.println("");
            System.out.println("-- Consola Nueva Creada Correctamente 🎲");
            System.out.println("");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Consolas> obtenerTodos(){
        List<Consolas> consolas = new ArrayList<>();
        String sql = "SELECT * FROM consolas";
        try(Statement stmt = connection.createStatement()){
            ResultSet resultado = stmt.executeQuery(sql);
            while(resultado.next()){
                System.out.println("");
                System.out.println("LISTA DE CONSOLAS REGISTRADAS 😜");
                consolas.add(new Consolas(resultado.getInt("id_consola"),
                        resultado.getString("nombre"),
                        resultado.getString ("fabricante"),
                        resultado.getInt("anio_lanzamiento")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }return consolas;
    }

    public void actualizarConsolas(Consolas co){
        String sql = "UPDATE consolas SET nombre = ?, fabricante = ?, anio_lanzamiento = ? WHERE id_consola = ?";
        try(PreparedStatement stmt=connection.prepareStatement(sql)){
            stmt.setString(1, co.getNombre());
            stmt.setString(2, co.getFabricante());
            stmt.setInt(3, co.getAnio_lanzamiento());
            stmt.setInt(4, co.getId_consola());
            stmt.executeUpdate();
            System.out.println("");
            System.out.println("-- Consola Actualizada Correctamente 🎲");
            System.out.println("");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void eliminarConsola(int id){
        String sql = "DELETE FROM consolas WHERE id_consola = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
            System.out.println("");
            System.out.println("-- Consola Eliminada Correctamente 🎲");
            System.out.println("");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}