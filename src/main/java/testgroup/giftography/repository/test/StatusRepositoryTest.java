package testgroup.giftography.repository.test;

import testgroup.giftography.instances.Client;
import testgroup.giftography.instances.OrderStatus;
import testgroup.giftography.jdbc.SQLDatabaseConnection;
import testgroup.giftography.repository.StatusRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

public class StatusRepositoryTest {

    Connection connection = new SQLDatabaseConnection().getConnection();
    StatusRepository statusRepository = new StatusRepository(connection);

    public void statusTest() {
        try {
            int orderStatusId = statusRepository.getOrderStatusId(OrderStatus.NEW);
            System.out.println(orderStatusId);
        } catch (SQLException throwables) {
            System.err.println("ALERT!!!");
            throwables.printStackTrace();
        }

        try {
            OrderStatus orderStatus = statusRepository.getOrderStatus(1);
            System.out.println(orderStatus);
        } catch (SQLException throwables) {
            System.err.println("ALERT!!!");
            throwables.printStackTrace();
        }
    }
}
