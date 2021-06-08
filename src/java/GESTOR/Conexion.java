package GESTOR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConexion() throws Exception{
        Connection con = null;
        String usuario = "root";
        String clave = "";
        String url = "jdbc:mysql://localhost/bd_desarrollo";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = (Connection) DriverManager.getConnection(url, usuario, clave);
        return con;
    } 
}
