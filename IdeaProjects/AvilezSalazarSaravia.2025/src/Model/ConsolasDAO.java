package Model;
import java.sql.*;
import java.util.*;
public class ConsolasDAO {
    private Connection connection;
    public ConsolasDAO(){
        try{
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/videojuegos", "root", "");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    //CARGA UNA NUEVA CONSOLA EN LA BD
    public void crearConsolas(Consolas co ){
        String sql="INSERT INTO consolas(nombre, fabricante, anio_lanzamiento) VALUES(?,?,?)";
        try(PreparedStatement stmt=connection.prepareStatement(sql)){
            stmt.setString(1, co.getNombre());
            stmt.setString(2, co.getFabricante());
            stmt.setInt(3, co.getAnio_lanzamiento());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    //ADQUIERE TODAS LAS CONSOLAS DE LA BD
    public List<Consolas> obtenerTodos(){
        List<Consolas> consolas=new ArrayList<>();
        String sql="SELECT * FROM consolas";
        try(Statement stmt = connection.createStatement()){
            ResultSet resultado= stmt.executeQuery(sql);
            while(resultado.next()){
                //CARGA CADA CONSOLA EN UN OBJETO Y LO AÑADE A LA LISTA
                consolas.add(new Consolas(
                        resultado.getInt("id_consola"),
                        resultado.getString("nombre"),
                        resultado.getString ("fabricante"),
                        resultado.getInt("anio_lanzamiento")));

            }
        }catch(SQLException e){
            e.printStackTrace();
        }return consolas;
    }


    //ACTUALIZA UNA CONSOLA EN LA BD
    public boolean actualizarConsolas(Consolas co ){

        String sql="UPDATE consolas SET nombre= ?, fabricante=?, anio_lanzamiento=? WHERE id_consola=?";
        try(PreparedStatement stmt=connection.prepareStatement(sql)){
            stmt.setString(1, co.getNombre());
            stmt.setString(2, co.getFabricante());
            stmt.setInt(3, co.getAnio_lanzamiento());
            stmt.setInt(4, co.getId_consola());
            int resultado=stmt.executeUpdate();
            return resultado>0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    //ELIMINA UNA CONSOLA DE LA BD SEG´´UN EL ID
    public boolean eliminarConsola(int id){
        String sql="DELETE FROM consolas WHERE id_consola=?";
        try(PreparedStatement stmt=connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            int filasAfectadas=stmt.executeUpdate();//retorna la cantidad de filas que se eliminaron
            return filasAfectadas>0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
