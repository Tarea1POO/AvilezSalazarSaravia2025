package Model;
import java.sql.*;
import java.util.*;
public class ControlesDAO {
    private Connection connection;
    public ControlesDAO(){
        try{
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/videojuegos", "root", "");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void crearControles(Controles con ){
        String sql="INSERT INTO controles(tipo, consola_compatible, estado) VALUES(?,?,?)";
        try(PreparedStatement stmt=connection.prepareStatement(sql)){
            stmt.setString(1, con.getTipo());
            stmt.setString(2, con.getConsola_compatible());
            stmt.setString(3, con.getEstado());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public List<Controles> obtenerTodos(){
        List<Controles> controles=new ArrayList<>();
        String sql="SELECT * FROM controles";
        try(Statement stmt = connection.createStatement()){
            ResultSet resultado= stmt.executeQuery(sql);
            while(resultado.next()){
                controles.add(new Controles(resultado.getInt("id_control"),
                        resultado.getString("tipo"),
                        resultado.getString ("consola_compatible"),
                        resultado.getString("estado")));

            }
        }catch(SQLException e){
            e.printStackTrace();
        }return controles;
    }
    public void actualizarControles(Controles con ){
        String sql="UPDATE controles SET tipo= ?, consola_compatible=?, estado=? WHERE id_control=?";
        try(PreparedStatement stmt=connection.prepareStatement(sql)){
            stmt.setString(1, con.getTipo());
            stmt.setString(2, con.getConsola_compatible());
            stmt.setString(3, con.getEstado());
            stmt.setInt(4, con.getId_control());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    public void eliminarControles(int id){
        String sql="DELETE FROM controles WHERE id_control=?";
        try(PreparedStatement stmt=connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
