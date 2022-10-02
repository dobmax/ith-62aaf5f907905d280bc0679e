package ua.ithillel.lesson14.homework;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

public class CoffeeOrderBoard {
    private int currentOrderNumber = 0;
    private Deque<Order> orders = new LinkedList<>();

    public void add(String clientName) {
        orders.addLast(new Order(++currentOrderNumber, clientName));
    }

    public Order deliver() {
        return orders.removeFirst();
    }

    public Optional<Order> deliver(int orderNumber) {
        var maybeOrder = orders.stream()
                .filter(order -> order.getOrderNumber() == orderNumber)
                .findFirst();

        maybeOrder.ifPresent(order -> orders.remove(order));

        return maybeOrder;
    }
}
