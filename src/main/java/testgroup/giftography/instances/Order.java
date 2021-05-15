package testgroup.giftography.instances;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private final int id;
    private final int clientId;
    private final LocalDate dateOfCreation = LocalDate.now();
    private OrderStatus orderStatus = OrderStatus.NEW;
    private Map<Product, Integer> productIntegerMap = new HashMap<>();

    public Order(int id, int clientId, Date dateOfCreation, int productId) {
        this.id = id;
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public int getClientId() {
        return clientId;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Map<Product, Integer> getOrderMap() {
        return productIntegerMap;
    }

    public void setOrderMap(Map<Product, Integer> orderMap) {
        this.productIntegerMap = orderMap;
    }
}