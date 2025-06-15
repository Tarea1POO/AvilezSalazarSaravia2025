package Model;
import java.sql.*;
import java.util.*;
public class JugadoresDAO {
    //CONEXIÓN A LA BD
    private Connection connection;

    //CONSTRUCTOR QUE ESTABLECE LA CONEXIÓN CON LA BD
    public JugadoresDAO(){
        try{
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/videojuegos", "root", "");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //CARGA UN NUEVO JUGADOR EN LA BD
    public void crearJugador(Jugadores ju ){
        String sql="INSERT INTO jugadores(nombre, nickname, edad) VALUES(?,?,?)";
        try(PreparedStatement stmt=connection.prepareStatement(sql)){
            stmt.setString(1, ju.getNombre());
            stmt.setString(2, ju.getNickname());
            stmt.setInt(3, ju.getEdad());
            //REALIZA LA ACTUALIZACIÓN EN LA BD
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    //ADQUIERE TODOS LOS JUGADORES DE LA BD
    public List<Jugadores> obtenerTodos(){
        List<Jugadores> jugadores=new ArrayList<>();
        String sql="SELECT * FROM jugadores";
        try(Statement stmt = connection.createStatement()){
            ResultSet resultado= stmt.executeQuery(sql);
            while(resultado.next()){
                //CARGA CADA JUGADOR EN UN OBJETO Y LO AÑADE A LA LISTA
                jugadores.add(new Jugadores(
                        resultado.getInt("id_jugador"),
                        resultado.getString("nombre"),
                        resultado.getString ("nickname"),
                        resultado.getInt("edad")));

            }
        }catch(SQLException e){
            e.printStackTrace();
        }return jugadores;
    }

    //ACTUALIZA UN JUGADOR EN LA BD
    public boolean actualizarJugadores(Jugadores ju ){

        String sql="UPDATE jugadores SET nombre= ?, nickname=?, edad=? WHERE id_jugador=?";
        try(PreparedStatement stmt=connection.prepareStatement(sql)){

            stmt.setString(1, ju.getNombre());
            stmt.setString(2, ju.getNickname());
            stmt.setInt(3, ju.getEdad());
            stmt.setInt(4, ju.getId_jugador());
            int resultado=stmt.executeUpdate();
            return resultado >0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    //ELIMINA UN JUGADOR DE LA BD SEGÚN EL ID
    public boolean eliminarJugador(int id){
        String sql="DELETE FROM jugadores WHERE id_jugador=?";
        try(PreparedStatement stmt=connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            int filasAfectas= stmt.executeUpdate();//retorna la cantidad de filas que se eliminaron
            return filasAfectas >0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}

