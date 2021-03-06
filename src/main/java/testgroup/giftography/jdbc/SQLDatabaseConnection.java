package testgroup.giftography.jdbc;

import java.sql.*;

public class SQLDatabaseConnection {
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/gifts?" +
            "user=root&" + "password=root";
    private Connection connection;

    public SQLDatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(CONNECTION_URL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    //
//    public static void main(String[] args) throws ClassNotFoundException {
//        String connectionUrl =
//                "jdbc:mysql://localhost:3306/gifts?" +
//                        "user=root&" +
//                        "password=71498236";
//
//        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
//
//            String sql = "INSERT INTO client (ProductName, Price) Values (?, ?)";
//
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from client");
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                System.out.println(resultSet.getInt("clientId"));
//                System.out.println(resultSet.getString("firstName"));
//                System.out.println(resultSet.getString("secondName"));
//                System.out.println(resultSet.getString("address"));
//                System.out.println(resultSet.getString("phoneNumber"));
//                System.out.println(resultSet.getString("email"));
//                System.out.println("----------------------");
//            }
//        }
//        // Handle any errors that may have occurred.
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}