package testgroup.giftography.repository;

import testgroup.giftography.instances.Client;
import testgroup.giftography.instances.Order;
import testgroup.giftography.instances.OrderStatus;

import java.sql.*;
import java.time.LocalDate;

public class OrderRepository {

    Connection connection;

    public OrderRepository(Connection connection) {
        this.connection = connection;
    }

    public Order getOrder(int id) throws SQLException {
        String sql = "select * from myorder where orderid=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return new Order(
                id,
                resultSet.getInt("clientid"),
                LocalDate.now(),
                OrderStatus.valueOf(resultSet.getString("orderStatus"))
        );
    }

    public boolean addOrder(Order order) throws SQLException {
        String sql = "insert into myorder set client=?, dateOfCreation=?, status=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int statusId = new StatusRepository(connection).getOrderStatusId(OrderStatus.NEW);

        preparedStatement.setInt(1, order.getClientId());
        preparedStatement.setDate(2, Date.valueOf(order.getDateOfCreation()));
        preparedStatement.setInt(3, statusId);

        preparedStatement.executeUpdate();

        return true;
    }

    public boolean updateOrder(Order order) throws SQLException {
        String sql = "update myorder set clientId=?, dateOfCreation=?, orderStatus=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, order.getClientId());
        preparedStatement.setDate(2, Date.valueOf(order.getDateOfCreation()));
//        preparedStatement.setInt(3, order.getOrderStatus());

        preparedStatement.executeUpdate();

        return false;
    }
}
