package testgroup.giftography.instances;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private int id;
    private final int clientId;
    private LocalDate dateOfCreation = LocalDate.now();
    private OrderStatus orderStatus;
    private Map<Product, Integer> productIntegerMap = new HashMap<>();

    public int getId() {
        return id;
    }

    public Order(int id, int clientId, LocalDate dateOfCreation, OrderStatus orderStatus) {
        this.id = id;
        this.clientId = clientId;
        this.dateOfCreation = dateOfCreation;
        this.orderStatus = orderStatus;
    }

    public Order(int clientId, OrderStatus orderStatus) {
        this.clientId = clientId;
        this.orderStatus = orderStatus;
    }

    public int getClientId() {
        return clientId;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public OrderStatus getOrderStatus() {
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