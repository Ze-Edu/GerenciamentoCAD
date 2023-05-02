import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {

    private String usuario = "root";
    private String senha = "anima123";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "db_pessoas";
    public Connection conexao(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://"+host+":"+porta+"/"+bd+"?user="+usuario+"&password="+senha+"&useTimezone=true&serverTimezone=America/Sao_Paulo");
            return conn;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
