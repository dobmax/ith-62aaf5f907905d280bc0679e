package ua.ithillel.lesson38.homework.cart;

import org.springframework.stereotype.Repository;
import ua.ithillel.lesson38.homework.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

    public void add(Product product) {
    }

    public void remove(Product product) {
    }

    public void update(Product product) {
    }

    public Optional<Product> findById() {
        return Optional.empty();
    }

    public List<Product> getAll() {
        return Collections.emptyList();
    }
}
