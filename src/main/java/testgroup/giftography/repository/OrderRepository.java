package testgroup.giftography.repository;

import testgroup.giftography.instances.Client;
import testgroup.giftography.instances.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRepository {

    Connection connection;

    public OrderRepository(Connection connection) {
        this.connection = connection;
    }

    public Order getOrder(int id) throws SQLException {
        String sql = "select * from order where orderid=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Order(
                id,
                resultSet.getInt("clientId"),
                resultSet.getDate("dateOfCreation"),
                resultSet.getInt("orderStatus")
        );
    }

    public boolean addOrder(Order order) throws SQLException {
        String sql = "insert into order set clientId=?, dateOfCreation=?, orderStatus=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, order.getClientId());
        preparedStatement.setDate(2, order.getDateOfCreation());
        preparedStatement.setInt(3, order.getOrderStatus());

        preparedStatement.executeUpdate();

        return false;
    }

    public boolean updateOrder(Order order) throws SQLException {
        String sql = "update order set clientId=?, dateOfCreation=?, orderStatus=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, order.getClientId());
        preparedStatement.setDate(2, order.getDateOfCreation());
        preparedStatement.setInt(3, order.getOrderStatus());

        preparedStatement.executeUpdate();

        return false;
    }
}
