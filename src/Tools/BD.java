
package Tools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ben Nasr
 */
public class BD {  
    private Connection cnx;
    private static BD instance;
    
    private String url = "jdbc:mysql://remotemysql.com:3306/tcPmjQHMA8";
    private String user = "tcPmjQHMA8";
    private String password = "cHyEAAZjdg";
    
    
    
    
    private BD(){
        try {
            cnx= DriverManager.getConnection(url,user,password);
            System.out.println("connexion établie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static BD getInstance(){
            if (instance==null){
                instance =new BD();
            }
            return instance;
        }
    
    public Connection getCnx() {
        return cnx;
    }
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
