package ua.ithillel.lesson40.homework.data.access;

import ua.ithillel.lesson40.homework.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Optional<Order> findById(long id);
    List<Order> findAll();
    void add(Order order);
}
