package testgroup.giftography.jdbc;

import java.sql.*;

public class SQLDatabaseConnection {
    public static void main(String[] args) throws ClassNotFoundException {
        String connectionUrl =
                "jdbc:mysql://localhost:3306/gifts?" +
                        "user=root&" +
                        "password=71498236";

        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
            // Code here.
      //  Statement statement = connection.createStatement();
            System.out.println(connection.isClosed());
          //  String selectStatus = " select * from status;";
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}