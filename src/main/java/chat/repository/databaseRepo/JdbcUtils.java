package chat.repository.databaseRepo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class JdbcUtils {

    private Connection instance;

    private Connection getNewConnection() {
        Connection con = null;
        try {
            DriverManager.registerDriver(new SQLServerDriver());
            con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS;database=chat;encrypt=true;trustServerCertificate=true", "guest", "1234");
        } catch (SQLException e) {
            System.out.println("Error getting connection" + e);
        }
        return con;
    }

//    public JdbcUtils(Connection instance) {
//        this.instance = instance;
//    }

    public Connection getInstance() {
        try {
            if (instance == null || instance.isClosed()) {
                instance = getNewConnection();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return instance;
    }
}
