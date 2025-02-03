
package clases;
import java.sql.*;


public class Conexion {
    
    public static Connection conectar(){
        
        
        try{
            
            Connection bd = DriverManager.getConnection("jdbc:mysql://localhost/moon_bd", "root", "");
            return bd;
        
        }catch(SQLException e){
            System.err.println("error en la conecxion local!" + e);
        
            
        }
        
        
        return(null);
        
    }




        
    
    
    
}
