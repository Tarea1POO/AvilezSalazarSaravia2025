package Model;
import java.sql.*;
import java.util.*;
public class JuegosDAO {

    //CONEXIÓN A LA BD
    private Connection connection;

    //CONSTRUCTOR QUE ESTABLECE LA CONEXIÓN CON LA BD
    public JuegosDAO(){
        try{
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/videojuegos", "root", "");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //CARGA UN NUEVO JUEGO EN LA BD
    public void crearJuegos(Juegos jue ){
        String sql="INSERT INTO juegos(titulo, genero, consola_compatible, precio) VALUES(?,?,?,?)";
        try(PreparedStatement stmt=connection.prepareStatement(sql)){
            stmt.setString(1, jue.getTitulo());
            stmt.setString(2, jue.getGenero());
            stmt.setString(3, jue.getConsola_compatible());
            stmt.setInt(4, jue.getPrecio());
            //REALIZA LA ACTUALIZACION EN LA BD
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }


    //ADQUIERE TODOS LOS JUEGOS DE LA BD
    public List<Juegos> obtenerTodos(){
        List<Juegos> juegos=new ArrayList<>();
        String sql="SELECT * FROM juegos";
        try(Statement stmt = connection.createStatement()){
            ResultSet resultado= stmt.executeQuery(sql);
            while(resultado.next()){
                //CARGA CADA JUEGO EN UN OBJETO Y LO AÑADE A LA LISTA
                juegos.add(new Juegos(
                        resultado.getInt("id_juego"),
                        resultado.getString("titulo"),
                        resultado.getString ("genero"),
                        resultado.getString("consola_compatible"),
                        resultado.getInt("precio")));

            }
        }catch(SQLException e){
            e.printStackTrace();
        }return juegos;
    }


    //ACTUALIZA UN JUEGO EN LA BD
    public boolean actualizarJuegos(Juegos jue ){

        String sql="UPDATE juegos SET titulo= ?, genero=?, consola_compatible=?, precio=?WHERE id_juego=?";
        try(PreparedStatement stmt=connection.prepareStatement(sql)){
            stmt.setString(1, jue.getTitulo());
            stmt.setString(2, jue.getGenero());
            stmt.setString(3, jue.getConsola_compatible());
            stmt.setInt(4, jue.getPrecio());
            stmt.setInt(5, jue.getId_juego());
            int resultado=stmt.executeUpdate();
            return resultado>0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    //ELIMINA UN JUEGO DE LA BD SEGUN EL ID
    public boolean eliminarJuego(int id){
        String sql="DELETE FROM juegos WHERE id_juego=?";
        try(PreparedStatement stmt=connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            int filasAfectadas=stmt.executeUpdate();//retorna la cantidad de filas que se eliminaron
            return filasAfectadas >0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}