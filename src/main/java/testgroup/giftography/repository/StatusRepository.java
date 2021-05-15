package testgroup.giftography.repository;

import testgroup.giftography.instances.OrderStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusRepository {

    Connection connection;

    public StatusRepository(Connection connection) {
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
    public int getOrderStatusId(OrderStatus status) throws SQLException {
        String sql = "select * from status where status=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, status.name());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("statusid");
    }

    public boolean addOrderStatus(OrderStatus orderStatus) throws SQLException {
        String sql = "insert into status set status=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, orderStatus.name().toUpperCase());
        preparedStatement.executeUpdate();
        return true;
    }

    public boolean updateOrderStatus(OrderStatus orderStatus) throws SQLException {
        String sql = "update status set status=? where status=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, orderStatus.name());
        preparedStatement.setString(2, orderStatus.name());
        preparedStatement.executeUpdate();
        return true;
    }
}
