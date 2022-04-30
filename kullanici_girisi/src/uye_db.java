import com.mysql.jdbc.Connection;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.SQLException;



public class uye_db {
    public static final String kullanici_adi = "root";
    public static final String parola = "Gelisim2022!";
    public static final String dbUrl = "jdbc:mysql://localhost:3306/kullanici_girisi?autoReconnect=true&useSSL=false";
    
    public Connection getConnection() throws SQLException {
        
        return (Connection) DriverManager.getConnection(dbUrl,kullanici_adi,parola);
    
    }
    
    public void ShowError (SQLException exception){
        System.out.println("Error:" + exception.getMessage());
        System.out.println("Error Code:" + exception.getErrorCode());
    }
    
}
