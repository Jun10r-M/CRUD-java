package conexion;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    String db = "db_ventas";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;

    public Connection conectar(){
        try{
            Class.forName(driver);
            cx = DriverManager.getConnection(url + db, user, password);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al conectar con la base de datos"+ db);
        }
        return cx;
    }

    public void desconectar(){
       try {
           cx.close();
       }catch (SQLException ex) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public static void main(String[]args){
        Conexion conexion = new Conexion();
        conexion.conectar();
    }
}
