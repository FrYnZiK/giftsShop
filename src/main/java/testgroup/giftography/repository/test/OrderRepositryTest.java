package testgroup.giftography.repository.test;

import testgroup.giftography.instances.Client;
import testgroup.giftography.instances.Order;
import testgroup.giftography.instances.OrderStatus;
import testgroup.giftography.jdbc.SQLDatabaseConnection;
import testgroup.giftography.repository.ClientRepository;
import testgroup.giftography.repository.OrderRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

public class OrderRepositryTest {

    Connection connection = new SQLDatabaseConnection().getConnection();
    OrderRepository orderRepository = new OrderRepository(connection);

    public void orderTest() {
        try {
            Order orderId = orderRepository.getOrder(1);
            System.out.println(orderId);
        } catch (SQLException throwables) {
            System.err.println("ALERT!!!");
            throwables.printStackTrace();
        }
    }
}
