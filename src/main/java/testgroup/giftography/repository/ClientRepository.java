package testgroup.giftography.repository;

import testgroup.giftography.instances.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRepository {
    Connection connection;

    public ClientRepository(Connection connection) {
        this.connection = connection;
    }

    public Client getClient(int id) throws SQLException {
        String sql = "select * from client where clientid=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Client(
                id,
                resultSet.getString("firstName"),
                resultSet.getString("secondName"),
                resultSet.getString("address"),
                resultSet.getString("phoneNumber"),
                resultSet.getString("email")
        );
    }

    public Client getClient(String firstName, String secondName) throws SQLException {
        String sql = "select * from client where firstName= ?, secondName = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("Client First name: " + resultSet.getString("firstName"));
            System.out.println("Client Second name: " + resultSet.getString("secondName"));
            System.out.println("Client Address: " + resultSet.getString("address"));
            System.out.println("Client Phone number: " + resultSet.getString("phoneNumber"));
            System.out.println("Client Email: " + resultSet.getString("email"));
            preparedStatement.execute();
        }
        return null;
    }

    public boolean addClient(Client client) throws SQLException {
        String sql = "insert into client set firstname=?, secondname=?, address=?, phonenumber=?, email=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, client.getFirstName());
        preparedStatement.setString(2, client.getSecondName());
        preparedStatement.setString(3, client.getAddress());
        preparedStatement.setString(4, client.getPhoneNumber());
        preparedStatement.setString(5, client.getEmail());

        preparedStatement.executeUpdate();

        return false;
    }

    public boolean updateClient(Client client) throws SQLException {
        String sql = "update client set firstname=?, secondname=?, address=?, phonenumber=? where clientid= ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, client.getFirstName());
        preparedStatement.setString(2, client.getSecondName());
        preparedStatement.setString(3, client.getAddress());
        preparedStatement.setString(4, client.getPhoneNumber());
        preparedStatement.setInt(5, client.getId());
        preparedStatement.executeUpdate();

        return false;
    }

    public boolean deleteClient(int id) {
        return false;
    }


}
