package Bus_Reser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static final String url = "jdbc:mysql://localhost:3306/BusReservation";
    private static final String userName = "root";
    private static final String passWord = "3002";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,userName,passWord);
    }
}
