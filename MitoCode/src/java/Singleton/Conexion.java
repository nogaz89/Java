package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {    
    private static Conexion conectado;
    
    //Evitar instancia mediante "new"
    private Conexion(){        
    }    
    // Instancia sólo una vez por éste método
    // Se puede instanciar porque es static
    public static Conexion getConexion(){
        if(conectado == null){
            conectado = new Conexion();
        }
        return conectado;
    }
    public Connection conectar() throws ClassNotFoundException, ClassNotFoundException, SQLException{
        Connection dataBaseConnection;
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sourceURL = "jdbc:mysql://127.0.0.1:3306/choppin_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            dataBaseConnection = DriverManager.getConnection(sourceURL, "root", "");
            System.out.println("Conectado a MySQL");        
        return dataBaseConnection;    
    }
}
