package ua.ithillel.lesson40.homework.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.ithillel.lesson40.homework.data.access.OrderRepository;
import ua.ithillel.lesson40.homework.entity.Order;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Order findById(@PathVariable long id) {
        return orderRepository.findById(id).orElseThrow();
    }

    @GetMapping
    @ResponseBody
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
