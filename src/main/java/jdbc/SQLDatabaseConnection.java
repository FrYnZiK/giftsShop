package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseConnection {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) throws ClassNotFoundException {
//        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl =
                "jdbc:mysql://localhost:3306/gifts?" +
                        "user=root&" +
                        "password=71498236";

        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
            // Code here.

            String selectStatus = " select * from status;";
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}