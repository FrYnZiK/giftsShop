package testgroup.giftography.repository;

import testgroup.giftography.instances.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientRepository {
    Connection connection;

    public ClientRepository(Connection connection) {
        this.connection = connection;
    }

    public Client getClient(int id) {
        return null;
    }

    public Client getClient(String name, String surname) {
        return null;
    }

    public boolean addClient(Client client) {
        return false;
    }

    public boolean updateClient(Client client) throws SQLException {
        String sql = "update client set firstname=?, secondname=?, address=?, phonenumber=? where clientid= ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, client.getFirstName());
        preparedStatement.setString(2, client.getSecondName());
        preparedStatement.setString(3, client.getAddress());
        preparedStatement.setString(4, String.valueOf(client.getPhoneNumber()));
        preparedStatement.setInt(5, client.getId());
        preparedStatement.executeUpdate();

        return false;
    }

    public boolean deleteClient(int id) {
        return false;
    }


}
