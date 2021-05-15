package testgroup.giftography.repository;

import testgroup.giftography.instances.Client;
import testgroup.giftography.instances.ProductCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductCategoryRepository {

    Connection connection;

    public ProductCategoryRepository(Connection connection) {
        this.connection = connection;
    }

    public ProductCategory getProductCategory(int id) throws SQLException {

        String sql = "select * from category where categoryid=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return null;
//            return new ProductCategory(
//                    id,
//                    resultSet.getString("firstName"),
//                    resultSet.getString("secondName"),
//                    resultSet.getString("address"),
//                    resultSet.getString("phoneNumber"),
//                    resultSet.getString("email")
//            );
    }

    public Client getClient(String firstName, String secondName) throws SQLException {
        String sql = "select * from client where firstName= ?, secondName = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(2, firstName);
        preparedStatement.setString(3, secondName);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Client(
                firstName, secondName,
                resultSet.getString("address"),
                resultSet.getString("phoneNumber"),
                resultSet.getString("email")
        );
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

    public boolean deleteClient(int id) throws SQLException {

        String sql = "delete from client where clientid=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();

        return false;
    }
}

