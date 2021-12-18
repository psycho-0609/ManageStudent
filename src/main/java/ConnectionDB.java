import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static final String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static Connection con;
    private static final String urlConnect = "jdbc:sqlserver://localhost:1433;databaseName=student;User=sa;Password=123456";

    public static Connection getConnection(){
        if(con != null){
            return con;
        }

        try {
            Class.forName(jdbcDriver).newInstance();
            con = DriverManager.getConnection(urlConnect);
        } catch (SQLException | ClassNotFoundException throwables) {
            System.out.println("Connect db fail");
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return con;
    }
}
