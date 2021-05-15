package testgroup.giftography.repository;

import testgroup.giftography.instances.Client;
import testgroup.giftography.instances.OrderStatus;

import java.sql.*;

public class OrderStatusRepository {

    Connection connection;

    public OrderStatusRepository(Connection connection) {
        this.connection = connection;
    }

    public OrderStatus getOrderStatus(int id) throws SQLException {
        String sql = "select * from status where statusid=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return OrderStatus.valueOf(resultSet.getString("orderStatus"));
    }

    public boolean addOrderStatus(OrderStatus orderStatus) throws SQLException {
        String sql = "insert into status set status=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

//        preparedStatement.setInt(2, OrderStatus.valueOf(orderStatus.getOrderStatus()));

        preparedStatement.executeUpdate();

        return false;
    }

    public boolean updateOrderStatus(OrderStatus orderStatus) throws SQLException {
        String sql = "update status set status=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

//        preparedStatement.setString(2, OrderStatus.valueOf(orderStatus.getOrderStatus()));
        preparedStatement.executeUpdate();

        return false;
    }
}
