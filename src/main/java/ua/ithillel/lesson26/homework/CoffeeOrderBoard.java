package ua.ithillel.lesson26.homework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

public class CoffeeOrderBoard {

    private static final Logger log = LogManager.getLogger(CoffeeOrderBoard.class);

    private final Deque<Order> orders = new LinkedList<>();

    public void add(String name) {
        var order = new Order(orders.size() + 1, name);
        log.info("New order[#{}, for: {}] created", order.getNumber(), order.getName());
        orders.add(order);
        log.info("Order[#{}, for: {}] successfully added to the working pipe", order.getNumber(), order.getName());
    }

    public Optional<Order> deliver() {
        var maybeOrder = orders.pollFirst();
        if (maybeOrder == null) {
           log.info("Nothing to deliver. The working pipe is empty");
           return Optional.empty();
        }

        log.info("Order[#{}, for: {}] is ready and gonna be delivered", maybeOrder.getNumber(), maybeOrder.getName());
        return Optional.of(maybeOrder);
    }
}
